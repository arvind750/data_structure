import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    public static String removeDuplicateChars(String str) {
        StringBuilder sb = new StringBuilder(); // To store unique characters
        HashSet<Character> seen = new HashSet<>(); // To track seen characters
        
        // Iterate through the string
        for (char ch : str.toCharArray()) {
            // If character is not in HashSet, add it to StringBuilder and HashSet
            if (!seen.contains(ch)) {
                sb.append(ch);
                seen.add(ch);
            }
        }
        
        return sb.toString(); // Return the modified string
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine(); // Read input string
        
        // Call method and print result
        System.out.println("String after removing duplicates: " + removeDuplicateChars(input));
        
        sc.close(); // Close the scanner
    }
}
