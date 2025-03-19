import java.io.*;

public class WordCounter {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Change to the path of your file
        String targetWord = "Java"; // Change to the word you want to count
        
        int wordCount = countWordOccurrences(filePath, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");
    }

    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split line into words
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) { // Case-insensitive comparison
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return count;
    }
}
