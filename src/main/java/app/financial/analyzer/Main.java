package app.financial.analyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Path budget = Paths.get("FinAnalyzer/FinTable.CSV");
        try {
        FileManager fileManager = new FileManager(budget);
        } catch (IOException exception) {
            System.out.println("Error creating a file");
        }

    }
}
