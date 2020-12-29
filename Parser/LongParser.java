package sorting.Parser;

import sorting.*;
import java.util.Scanner;

public class LongParser extends AbstractDataParser implements Sortable {

    public LongParser(String type) {
        super(type);
        dataType = "numbers";
    }
    public LongParser(String type, String outputFile) {
        super(type);
        dataType = "numbers";
        this.outputFile = outputFile;
    }
    public LongParser(String type, Scanner inputFile) {
        super(type, inputFile);
        dataType = "numbers";
    }
    public LongParser(String type, String outputFile, Scanner inputFile) {
        super(type, inputFile);
        dataType = "numbers";
        this.outputFile = outputFile;
    }

    @Override
    public void read() {
        while (scanner.hasNext()) {
            String input = scanner.next();
            try {
                list.add(Long.parseLong(input));
            } catch (Exception e) {
                System.out.printf("\"%s\" is not a long. It will be skipped.", input);
            }
        }
    }
}