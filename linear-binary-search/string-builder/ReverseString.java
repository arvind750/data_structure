import java.util.Scanner;

public class ReverseString {
    public static String reverse(String str) {
        // Create a StringBuilder object and append the input string
        StringBuilder sb = new StringBuilder(str);
        
        // Reverse the string using StringBuilder's reverse() method
        sb.reverse();
        
        // Convert StringBuilder back to a string and return
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine(); // Read input string
        
        // Call the reverse method and print the reversed string
        System.out.println("Reversed string: " + reverse(input));
        
        sc.close(); // Close the scanner
    }
}
