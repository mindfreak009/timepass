package filehandling;

import java.io.FileReader;
import java.io.IOException;

public class FileReadingByCharacters {
    public static void main(String[] args) {

        try(FileReader fr = new FileReader("notes.txt")) {
            int letters = fr.read();
            while(fr.ready()){
                System.out.println((char) letters);
                letters = fr.read();
            }
            // This is not required, because try-with-resources automatically closes the opened resources.
            // fr.close()
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
