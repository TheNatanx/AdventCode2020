package com.company.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day02 {
    private final List<String> trimmedList = new ArrayList<>();
    private final List<String> passwords = new ArrayList<>();
    private final List<Character> expectedChars = new ArrayList<>();
    private final List<Integer> minNb = new ArrayList<>();
    private final List<Integer> maxNb = new ArrayList<>();
    private int firstAnswer = 0;
    private int secondAnswer = 0;

    public Day02() {
        fulfillInputList(trimmedList);

        toDecodeList(passwords, trimmedList);
        expectedChar(expectedChars, trimmedList);
        numberOfExpectedChars(minNb, maxNb, trimmedList);

        solveFirstPuzzle();
        solveSecondPuzzle();

        System.out.println("Les réponses pour la première et seconde étoile du jour 02 sont respectivement " + firstAnswer + " et " + secondAnswer);
    }

    private void solveFirstPuzzle() {
        for (int i = 0; i < passwords.size(); i++) {
            int occurrences = countOccurrences(passwords.get(i), expectedChars.get(i));
            if ((occurrences >= minNb.get(i)) && (occurrences <= maxNb.get(i))) {
                this.firstAnswer += 1;
            }
        }
    }

    private void solveSecondPuzzle() {
        int i = 0;
        for (String password : passwords) {
            char expected = expectedChars.get(i);
            char firstChar = password.charAt(minNb.get(i) - 1);
            char secondChar = password.charAt(maxNb.get(i) - 1);
            if (firstChar == expected ^ secondChar == expected) secondAnswer++;
            i++;
        }
    }

    private void toDecodeList(List<String> listToReturn, List<String> list) {
        list.forEach(s -> listToReturn.add(s.substring(s.indexOf(':') + 1).trim()));
    }

    private void expectedChar(List<Character> listToReturn, List<String> list) {
        list.forEach(s -> listToReturn.add(s.charAt(s.indexOf(':') - 1)));
    }

    private void numberOfExpectedChars(List<Integer> minNb, List<Integer> maxNb, List<String> list) {
        for (String s : list) {
            String left = s.split(":")[0].trim();
            String numbers = left.split(" ")[0].trim();
            String[] numbersArray = numbers.split("-");
            minNb.add(Integer.parseInt(numbersArray[0].trim()));
            maxNb.add(Integer.parseInt(numbersArray[1].trim()));
        }
    }

    private int countOccurrences(String string, char searchedChar) {
        long count = string.chars().filter(c -> c == searchedChar).count();
        return (int) count;
    }

    private void fulfillInputList(List<String> list) {
        try {
            Scanner scanner = new Scanner(new File("./src/com/company/day02/input.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line.trim());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

