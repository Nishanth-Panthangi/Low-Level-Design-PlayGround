import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FileTransferSimulation {
    private static final String CLIENT_FOLDER = "client";
    private static final String SERVER_FOLDER = "server";
    private static final String FILE_NAME = "fake_movie.mp4";
    private static final long FILE_SIZE = 1L * 1024 * 1024 * 1024; // 1 GB
    private static final long CHUNK_SIZE = 10L * 1024 * 1024; // 10 MB
    
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("Starting file generation...");
        generateFakeBinaryFile();
        logTime("File generation", startTime);

        System.out.println("Starting file splitting...");
        splitFileIntoChunks();
        logTime("File splitting", startTime);

        System.out.println("Starting chunk transfer...");
        transferChunks();
        logTime("Chunk transfer", startTime);

        System.out.println("Starting file stitching...");
        stitchChunks();
        logTime("File stitching", startTime);
    }

    private static void generateFakeBinaryFile() throws IOException {
        System.out.println("Generating fake binary file...");
        File clientFolder = new File(CLIENT_FOLDER);
        if (!clientFolder.exists()) {
            clientFolder.mkdir();
            System.out.println("Client folder created: " + CLIENT_FOLDER);
        }
        Path filePath = Paths.get(CLIENT_FOLDER, FILE_NAME);
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath.toFile()))) {
            byte[] buffer = new byte[8192];
            long bytesWritten = 0;
            while (bytesWritten < FILE_SIZE) {
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = (byte) (Math.random() < 0.5 ? 0 : 1);
                }
                bos.write(buffer);
                bytesWritten += buffer.length;
                if (bytesWritten % (100 * 1024 * 1024) == 0) { // Log every 100 MB written
                    System.out.println("Bytes written: " + bytesWritten);
                }
            }
        }
        System.out.println("Fake binary file generation complete: " + filePath);
    }

    private static void splitFileIntoChunks() throws IOException {
        System.out.println("Splitting file into chunks...");
        Path sourcePath = Paths.get(CLIENT_FOLDER, FILE_NAME);
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath.toFile()))) {
            byte[] buffer = new byte[(int) CHUNK_SIZE];
            int chunkCount = 0;
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) > 0) {
                Path chunkPath = Paths.get(CLIENT_FOLDER, FILE_NAME + ".chunk" + chunkCount);
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(chunkPath.toFile()))) {
                    bos.write(buffer, 0, bytesRead);
                }
                System.out.println("Created chunk: " + chunkPath);
                chunkCount++;
            }
        }
        System.out.println("File splitting complete.");
    }

    private static void transferChunks() throws InterruptedException {
        System.out.println("Transferring chunks to server...");
        File clientFolder = new File(CLIENT_FOLDER);
        File[] chunks = clientFolder.listFiles((dir, name) -> name.startsWith(FILE_NAME + ".chunk"));
        if (chunks == null) {
            System.out.println("No chunks found for transfer.");
            return;
        }

        ExecutorService executor = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(chunks.length);

        for (File chunk : chunks) {
            executor.submit(() -> {
                try {
                    Path targetPath = Paths.get(SERVER_FOLDER, chunk.getName());
                    Files.copy(chunk.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
                    latch.countDown();
                    System.out.println("Transferred: " + chunk.getName());
                } catch (IOException e) {
                    System.err.println("Error transferring chunk: " + chunk.getName());
                    e.printStackTrace();
                }
            });
        }

        latch.await();
        executor.shutdown();
        System.out.println("All chunks transferred to server.");
    }

    private static void stitchChunks() throws IOException {
        System.out.println("Stitching chunks back together...");
        File serverFolder = new File(SERVER_FOLDER);
        File[] chunks = serverFolder.listFiles((dir, name) -> name.startsWith(FILE_NAME + ".chunk"));
        if (chunks == null) {
            System.out.println("No chunks found for stitching.");
            return;
        }

        Path stitchedFilePath = Paths.get(SERVER_FOLDER, FILE_NAME);
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(stitchedFilePath.toFile()))) {
            List<Path> chunkPaths = new ArrayList<>();
            for (File chunk : chunks) {
                chunkPaths.add(chunk.toPath());
            }
            chunkPaths.sort((p1, p2) -> p1.getFileName().toString().compareTo(p2.getFileName().toString()));
            for (Path chunkPath : chunkPaths) {
                System.out.println("Stitching chunk: " + chunkPath);
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(chunkPath.toFile()))) {
                    byte[] buffer = new byte[8192];
                    int bytesRead;
                    while ((bytesRead = bis.read(buffer)) > 0) {
                        bos.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
        System.out.println("File stitching complete: " + stitchedFilePath);
    }

    private static void logTime(String task, long startTime) {
        long currentTime = System.currentTimeMillis();
        System.out.println(task + " completed in " + (currentTime - startTime) + " ms");
    }
}