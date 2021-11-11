package interfaces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import static interfaces.PureFunctionalInterface.*;
public interface PureFunctionalInterface extends Function<String, String> {

    static PureFunctionalInterface readFromFile() {
        return pure -> {
            String content = "";
            Path filePath = Paths.get(pure);
            try (BufferedReader br = Files.newBufferedReader(filePath)){
                String lines = "";
                while((lines = br.readLine())!=null){
                    content+=lines+"\n";
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;
        };
    }

    static PureFunctionalInterface writeToFile() {
        return pure -> {
            ArrayList<String> content = new ArrayList<String>(Arrays.asList(pure.split("=")));
            ArrayList<String> newContent = new ArrayList<>();
            newContent.add(content.get(0));
            try {
                Files.write(Paths.get("src/main/resources/WriteToThisFile"), newContent);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "Successfully written to file";
        };
    }

    default PureFunctionalInterface and (PureFunctionalInterface anotherFunction) {
        return pure -> writeToFile().apply(anotherFunction.apply(pure));
    }

    @Override
    String apply(String s);
}
