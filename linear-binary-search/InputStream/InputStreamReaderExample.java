import java.io.*;

public class InputStreamReaderExample {
    public static void main(String[] args) {
        String fileName = "example.txt"; // Name of the file to read

        try (
            // Step 1: Create a FileInputStream to read the file as a byte stream
            FileInputStream fis = new FileInputStream(fileName);

            // Step 2: Convert the byte stream into a character stream using InputStreamReader with UTF-8 encoding
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            // Step 3: Use BufferedReader for efficient reading of character data
            BufferedReader br = new BufferedReader(isr)
        ) {
            String line;
            
            // Step 4: Read and print the file content line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Print each line to the console
            }
        } catch (IOException e) {
            // Step 5: Handle any IO exceptions
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
