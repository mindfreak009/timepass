package filehandling;

import java.io.*;

public class FileReadingByLine {
    public static void main(String[] args) {
        // byte to char stream and then reading char stream
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("You typed :: " +br.readLine());
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File file = new File(".");
        for(String fileNames : file.list()) System.out.println(fileNames);

        try(BufferedReader br = new BufferedReader(new FileReader("D:\\timepass\\src\\main\\java\\notes.txt"))) {
            System.out.println(br.readLine());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
