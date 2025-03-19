import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String fileName = "userInput.txt"; // File where user input will be stored

        try (
            // Step 1: Create an InputStreamReader to read user input from the console
            InputStreamReader isr = new InputStreamReader(System.in);
            
            // Step 2: Wrap InputStreamReader in BufferedReader for efficient reading
            BufferedReader br = new BufferedReader(isr);

            // Step 3: Create a FileWriter to write user input to a file
            FileWriter fw = new FileWriter(fileName)
        ) {
            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            while (true) {
                line = br.readLine(); // Read user input

                if ("exit".equalsIgnoreCase(line)) { // Stop if user types "exit"
                    break;
                }

                fw.write(line + "\n"); // Write input to file with a new line
            }

            System.out.println("User input saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage()); // Handle exceptions
        }
    }
}
