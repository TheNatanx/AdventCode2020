package com.company.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day02 {
    private int firstAnswer = 0;
    private int secondAnswer = 0;
    private List<String> trimmedList = new ArrayList<>();
    private List<String> passwords = new ArrayList<>();
    private List<Character> expectedChars = new ArrayList<>();
    private List<Integer> minNb  = new ArrayList<>();
    private List<Integer> maxNb = new ArrayList<>();

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
            int occurrences = countOccurences(passwords.get(i), expectedChars.get(i));
            if ((occurrences >= minNb.get(i)) && (occurrences <= maxNb.get(i))) {
                this.firstAnswer += 1;
            }
        }
    }

    private void solveSecondPuzzle() {
        int i = 0;
        for (String password : passwords) {
            if (password.charAt(minNb.get(i)-1) == expectedChars.get(i) ^ (password.charAt(maxNb.get(i)-1) == expectedChars.get(i))) {
                secondAnswer++;
            }
            i++;
        }
    }

    private void fulfillInputList(List<String> list) {
        try {
            Scanner scanner = new Scanner(new File("./src/com/company/day02/input.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line.replace(" ", ""));
            }
            scanner.close();
        } catch  (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void toDecodeList(List<String> listToReturn, List<String> list) {
        for (String s : list) {
            listToReturn.add(s.substring(s.indexOf(':') + 1));
        }
    }

    private void expectedChar(List<Character> listToReturn, List<String> list) {
        for (String s : list) {
            listToReturn.add(s.charAt(s.indexOf(':') - 1));
        }
    }

    private void numberOfExpectedChars(List<Integer> minNb, List<Integer> maxNb, List<String> list) {
        for (String s : list) {
            if (s.indexOf('-') - 1 == 0) {
                minNb.add(Integer.parseInt(String.valueOf(s.charAt(0))));
            } else {
                minNb.add(Integer.parseInt(s.substring(0, s.indexOf('-'))));
            }
            if (s.indexOf('-') + 1 == s.indexOf(':') - 2) {
                maxNb.add(Integer.parseInt(String.valueOf(s.charAt(s.indexOf('-') + 1))));
            } else {
                maxNb.add(Integer.parseInt(s.substring(s.indexOf('-') + 1, s.indexOf('-') + 3)));
            }
        }
    }

    private int countOccurences(String string, char searchedChar) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == searchedChar) {
                count++;
            }
        }
        return count;
    }
}

