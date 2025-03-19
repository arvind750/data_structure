import java.util.Scanner;

public class ConcatenateStrings {
    public static String concatenateStrings(String[] words) {
        StringBuffer sb = new StringBuffer(); // Create a StringBuffer for efficient concatenation
        
        // Append each string from the array to StringBuffer
        for (String word : words) {
            sb.append(word);
        }
        
        return sb.toString(); // Convert StringBuffer to a string and return
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline
        
        String[] words = new String[n]; // Create an array for input strings
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine(); // Read each string
        }
        
        // Call method and print concatenated string
        System.out.println("Concatenated string: " + concatenateStrings(words));
        
        sc.close(); // Close the scanner
    }
}
