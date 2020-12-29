package sorting.Parser;

import sorting.*;
import java.util.Scanner;

public class WordParser extends AbstractDataParser<String> implements Sortable{

    public WordParser(String type) {
        super(type);
        dataType = "words";
    }
    public WordParser(String type, String outputFile) {
        super(type);
        dataType = "words";
        this.outputFile = outputFile;
    }
    public WordParser(String type, Scanner inputFile) {
        super(type, inputFile);
        dataType = "words";
    }
    public WordParser(String type, String outputFile, Scanner inputFile) {
        super(type, inputFile);
        dataType = "words";
        this.outputFile = outputFile;
    }


    @Override
    public void read() {
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
    }
}