package sorting.Parser;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractDataParser<T> {
    Scanner scanner;
    List<T> list = new ArrayList<>();
    Map<T, Integer> map = new TreeMap<>();
    Map<T, Integer> result;
    String dataType;
    String sortType;
    String outputFile;

    AbstractDataParser(String type) {
        this.sortType = type;
        scanner = new Scanner(System.in);
    }
    AbstractDataParser(String type, Scanner inputFile) {
        this.sortType = type;
        this.scanner = inputFile;
    }


    public void sort() {
        if ("natural".equals(sortType)) {
            list.sort(null);
        } else if ("byCount".equals(sortType)) {
            for (T num : list) {
                Integer times = Collections.frequency(list, num);
                map.put(num, times);
            }
            result = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }
    }

    public void output() {
        System.out.printf("Total %s: %d.%n", dataType, list.size());
        if ("natural".equals(sortType)) {
            System.out.print("Sorted data: ");

            if ("lines".equals(dataType))
                System.out.println();

            for (T num : list) {

                if ("lines".equals(dataType)) {
                    System.out.println(num);
                } else {
                    System.out.print(num + " ");
                }
            }
        } else if ("byCount".equals(sortType)) {
            for (var num: result.entrySet()) {
                System.out.println(num.getKey() + ": " + num.getValue() + " time(s), " + num.getValue() * 100 / list.size() + "%");
            }
        }
    }

    public void outputToFile() {
        File file = new File(outputFile);
        try (PrintWriter printWriter = new PrintWriter(file)) {

            printWriter.printf("Total %s: %d.%n", dataType, list.size());
            if ("natural".equals(sortType)) {
                printWriter.print("Sorted data: ");

                if ("lines".equals(dataType))
                    printWriter.println();

                for (T num : list) {

                    if ("lines".equals(dataType)) {
                        printWriter.println(num);
                    } else {
                        printWriter.print(num + " ");
                    }
                }
            } else if ("byCount".equals(sortType)) {
                for (var num: result.entrySet()) {
                    printWriter.println(num.getKey() + ": " + num.getValue() + " time(s), " + num.getValue() * 100 / list.size() + "%");
                }
            }
        } catch (IOException e) {
            System.out.println("IOException bei printEncryptedStringToFile");
        }
    }
}