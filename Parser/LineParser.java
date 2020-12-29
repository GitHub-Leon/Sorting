package sorting.Parser;

import sorting.*;
import java.util.Scanner;

public class LineParser extends AbstractDataParser<String> implements Sortable {

    public LineParser(String type) {
        super(type);
        dataType = "lines";
    }
    public LineParser(String type, String outputFile) {
        super(type);
        dataType = "lines";
        this.outputFile = outputFile;
    }
    public LineParser(String type, Scanner inputFile) {
        super(type, inputFile);
        dataType = "lines";
    }
    public LineParser(String type, String outputFile, Scanner inputFile) {
        super(type, inputFile);
        dataType = "lines";
        this.outputFile = outputFile;
    }

    @Override
    public void read() {
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
    }
}