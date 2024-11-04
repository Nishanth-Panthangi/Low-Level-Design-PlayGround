import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapReduceDemo {

    // Method to square each number in a list and return a new list
    public List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .map(n -> n * n) // Square each number
                      .collect(Collectors.toList()); // Collect the results into a list
    }

    // Method to sum all numbers in a list
    public int sumNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .reduce(0, Integer::sum); // Sum all numbers, starting with 0
    }

    public static void main(String[] args) {
        MapReduceDemo demo = new MapReduceDemo();

        // Example list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Demonstrate map operation
        List<Integer> squaredNumbers = demo.squareNumbers(numbers);
        System.out.println("Squared Numbers: " + squaredNumbers);

        // Demonstrate reduce operation
        int sum = demo.sumNumbers(numbers);
        System.out.println("Sum of Numbers: " + sum);
    }
}