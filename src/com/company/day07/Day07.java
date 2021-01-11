package com.company.day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day07 {

    private List<String> input = new ArrayList<>();

    private void fillList() {
        try {
            Scanner scanner = new Scanner(new File("./src/com/company/day07/input.txt"));
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                input.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
