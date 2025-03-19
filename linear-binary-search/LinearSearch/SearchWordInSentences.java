import java.util.Scanner;

public class SearchWordInSentences {
    // Method to perform Linear Search for a word in sentences
    public static String findSentenceWithWord(String[] sentences, String word) {
        // Iterate through each sentence in the array
        for (String sentence : sentences) {
            if (sentence.contains(word)) { // Check if the sentence contains the word
                return sentence; // Return the first matching sentence
            }
        }
        return "Not Found"; // Return "Not Found" if no sentence contains the word
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for the number of sentences
        System.out.print("Enter the number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        String[] sentences = new String[n];

        // Taking input for sentences
        System.out.println("Enter the sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = sc.nextLine();
        }

        // Taking input for the word to search
        System.out.print("Enter the word to search: ");
        String word = sc.next();

        // Calling the method to find the sentence containing the word
        String result = findSentenceWithWord(sentences, word);

        // Output the result
        System.out.println("Result: " + result);

        sc.close(); // Close the scanner
    }
}
