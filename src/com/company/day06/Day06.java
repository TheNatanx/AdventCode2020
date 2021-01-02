package com.company.day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Day06 {
    private final List<String> input = new ArrayList<>();
    private int firstAnswer = 0;
    private int secondAnswer = 0;

    public Day06() {
        fillList();
        firstStar();
        secondStar();
        System.out.println("Les réponses pour la première et seconde étoile du jour 06 sont respectivement " + firstAnswer + " et " + secondAnswer);
    }

    private void firstStar() {
        for (String s : input) {
            HashSet<Character> questions = new HashSet<>();
            for (Character c : s.toCharArray()) {
                questions.add(c);
            }
            firstAnswer += questions.size();
        }
    }

    private void secondStar() {

    }

    private void fillList() {
        try {
            Scanner scanner = new Scanner(new File("C:/Users/Nath/Documents/AdventCode2020/src/com/company/day06/input.txt"));
            StringBuilder entity = new StringBuilder();
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    input.add(entity.toString());
                    entity = new StringBuilder();
                    continue;
                }
                    entity.append(line);
            }
            input.add(entity.toString());
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
