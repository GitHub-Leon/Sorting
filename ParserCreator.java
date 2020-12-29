package sorting;

import java.util.Scanner;
import sorting.Parser.*;

public class ParserCreator {
    public static Sortable create(String data, String sort) {
        Sortable sorter;
        switch (data) {
            case "long":
                sorter = new LongParser(sort);
                break;
            case "word":
                sorter = new WordParser(sort);
                break;
            case "line":
                sorter = new LineParser(sort);
                break;
            default:
                sorter = null;
                break;
        }
        return sorter;
    }
    public static Sortable create(String data, String sort, String outputFile) {
        Sortable sorter;
        switch (data) {
            case "long":
                sorter = new LongParser(sort, outputFile);
                break;
            case "word":
                sorter = new WordParser(sort, outputFile);
                break;
            case "line":
                sorter = new LineParser(sort, outputFile);
                break;
            default:
                sorter = null;
                break;
        }
        return sorter;
    }
    public static Sortable create(String data, String sort, Scanner inputFile) {
        Sortable sorter;
        switch (data) {
            case "long":
                sorter = new LongParser(sort, inputFile);
                break;
            case "word":
                sorter = new WordParser(sort, inputFile);
                break;
            case "line":
                sorter = new LineParser(sort, inputFile);
                break;
            default:
                sorter = null;
                break;
        }
        return sorter;
    }
    public static Sortable create(String data, String sort, String outputFile, Scanner inputFile) {
        Sortable sorter;
        switch (data) {
            case "long":
                sorter = new LongParser(sort, outputFile, inputFile);
                break;
            case "word":
                sorter = new WordParser(sort, outputFile, inputFile);
                break;
            default:
                sorter = new LineParser(sort, outputFile, inputFile);
                break;
        }
        return sorter;
    }
}
