import java.io.*;
import java.util.StringTokenizer;

public class PerformanceComparison {

    // Method to concatenate strings 1,000,000 times using StringBuilder
    public static void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append("hello");
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Method to concatenate strings 1,000,000 times using StringBuffer
    public static void testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append("hello");
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Method to count words in a file using FileReader
    public static void testFileReader(String filePath) {
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            long startTime = System.nanoTime();
            int wordCount = 0;
            String line;

            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }

            long endTime = System.nanoTime();
            System.out.println("FileReader Word Count: " + wordCount);
            System.out.println("FileReader Time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to count words in a file using InputStreamReader
    public static void testInputStreamReader(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            long startTime = System.nanoTime();
            int wordCount = 0;
            String line;

            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }

            long endTime = System.nanoTime();
            System.out.println("InputStreamReader Word Count: " + wordCount);
            System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Compare StringBuilder vs StringBuffer
        testStringBuilder();
        testStringBuffer();

        // Provide the path to a large file (e.g., 100MB)
        String filePath = "large_text_file.txt";  // Replace with actual file path

        // Compare FileReader vs InputStreamReader
        testFileReader(filePath);
        testInputStreamReader(filePath);
    }
}
