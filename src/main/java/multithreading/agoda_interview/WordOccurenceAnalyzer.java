package multithreading.agoda_interview;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordOccurenceAnalyzer {

        private static final String FOLDER_PATH= "D:/timepass/src/main/java/multithreading/agoda_interview/data";

        public List<String> findNthOccurence() throws IOException {

                // read/get all the files from the folder
                List<Path> files = Files.walk(Paths.get(FOLDER_PATH))
                        .filter(Files::isRegularFile)
                        .collect(Collectors.toList());
                return new ArrayList<>();
        }

        public static void main(String[] args) {
                WordOccurenceAnalyzer wordOccurenceAnalyzer = new WordOccurenceAnalyzer();
            try {
                    List<String> nthOccurence = wordOccurenceAnalyzer.findNthOccurence();
                    System.out.println(nthOccurence);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}
