package sorting;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        String outputFile = "";
        String inputFile = "";
        Scanner inputFileScanned = null;
        Sortable input;

        //checks input (wrong arguments) and outputs errors
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.contentEquals("-dataType")) {
                try {
                    if (args[i + 1].equals("long") || args[i + 1].equals("word") || args[i + 1].equals("line")) {
                        params.put(arg, args[i + 1]);
                        i++;
                    } else {
                        System.out.println("No data type defined!");
                    }
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    System.out.println("No data type defined!");
                }
            } else if (arg.contentEquals("-sortingType")) {
                try {
                    if (args[i + 1].equals("natural") || args[i + 1].equals("byCount")) {
                        params.put(arg, args[i + 1]);
                        i++;
                    } else {
                        System.out.println("No sorting type defined!");
                    }
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    System.out.println("No sorting type defined!");
                }
            } else if (arg.contentEquals("-inputFile")) {
                try {
                    if (args[i + 1].matches("\\w+\\.\\w+")) {
                        inputFile = args[i + 1];
                        inputFileScanned = new Scanner(inputFile);
                        i++;
                    }
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    System.out.println("No input file defined!");
                }
            } else if (arg.contentEquals("-outputFile")) {
                try {
                    if (args[i + 1].matches("\\w+\\.\\w+")) {
                        outputFile = args[i + 1];
                        i++;
                    }
                } catch (ArrayIndexOutOfBoundsException aioobe) {
                    System.out.println("No output file defined!");
                }
            } else {
                System.out.printf("\"%s\" is not a valid parameter. It will be skipped.\n", args[i]);
            }
        }

        String dataType = params.get("-dataType") == null ? "void" : params.get("-dataType");
        String sortType = params.get("-sortingType") == null ? "natural" : params.get("-sortingType");

        //check where the output needs to go
        if (!outputFile.isEmpty() && !inputFile.isEmpty()) {
            input = ParserCreator.create(dataType, sortType, outputFile, inputFileScanned);
        } else if (!inputFile.isEmpty()) {
            input = ParserCreator.create(dataType, sortType, inputFileScanned);
        } else if (!outputFile.isEmpty()) {
            input = ParserCreator.create(dataType, sortType, outputFile);
        } else {
            input = ParserCreator.create(dataType, sortType);
        }
        try {
            input.read();
            input.sort();
            if (outputFile.isEmpty()) {
                input.output();
            } else {
                input.outputToFile();
            }
        } catch (Exception e) {
            System.out.println("Program stopped.");
        }
    }
}