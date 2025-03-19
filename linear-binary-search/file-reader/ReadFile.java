import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        // Try-with-resources to ensure file is closed automatically
        try (FileReader fr = new FileReader("sample.txt");
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            // Read file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Print each line
            }
        } 
        catch (IOException e) {
            // Handle exceptions related to file reading
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
