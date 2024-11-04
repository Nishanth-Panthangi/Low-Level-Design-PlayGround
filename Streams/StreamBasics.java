import java.util.*;
import java.util.stream.*;
/**
 * Streams simplify collection processing.
 * 
 */
public class StreamBasics {
    List<Integer> numbers;

    public StreamBasics(){
        numbers = new ArrayList<>();
        for(int i = 1; i <= 100; i++){
            numbers.add(i);
        }
    }

    // Step 1: Stub functions to implement
    public List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .filter(n -> n % 2 == 0)
                      .collect(Collectors.toList());
    }

    public List<Integer> squareNumbers(List<Integer> numbers) {
        // Implement mapping to square each number
        return numbers.stream()
                  .map(n -> n * n) // Square each number
                  .collect(Collectors.toList()); // Collect the results into a list
    }

    public List<Integer> collectResults(List<Integer> numbers) {
        // Filter even numbers, square them, and collect into a new list
        return numbers.stream()
                  .filter(n -> n % 2 == 0) // Keep only even numbers
                  .map(n -> n * n) // Square each number
                  .collect(Collectors.toList()); // Collect the results into a list
    }

    public static void main(String[] args) {
        StreamBasics basics = new StreamBasics();
        
        // Populate a list of integers from 1 to 10
        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

        // Use the filterEvenNumbers method
        List<Integer> evenNumbers = basics.filterEvenNumbers(numbers);
        System.out.println("Even Numbers: " + evenNumbers);

        // Use the squareNumbers method
        List<Integer> squaredNumbers = basics.squareNumbers(numbers);
        System.out.println("Squared Numbers: " + squaredNumbers);

        // Use the collectResults method
        List<Integer> collectedResults = basics.collectResults(numbers);
        System.out.println("Collected Results (Even and Squared): " + collectedResults);

        // Sum of all numbers
        int sum = numbers.stream()
            .reduce(0, Integer::sum); // Sum all numbers, starting with 0
        System.out.println("Sum of Numbers: " + sum);

        // Sort numbers in descending order
        List<Integer> sortedNumbers = numbers.stream()
            .sorted(Comparator.reverseOrder()) // Sort in reverse (descending) order
            .collect(Collectors.toList()); // Collect the results into a list
        System.out.println("Sorted Numbers (Descending): " + sortedNumbers);

        // Remove duplicates and limit to first 5 elements
        List<Integer> limitedNumbers = Stream.of(1, 2, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10)
            .distinct() // Remove duplicates
            .limit(5) // Limit to first 5 elements
            .collect(Collectors.toList()); // Collect the results into a list
        System.out.println("Limited Numbers: " + limitedNumbers);

        // Print each number (side-effect)
        numbers.stream()
            .forEach(System.out::println); // Print each number
    }
}
