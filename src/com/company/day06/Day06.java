package com.company.day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day06 {
    private final List<String> input = new ArrayList<>();
    private final List<List<String>> input2 = new ArrayList<>();
    private int firstAnswer = 0;
    private int secondAnswer = 0;
    private final List<Character> alphabet = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

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
        for (List<String> list : input2) {
            for (Character character : alphabet) {

            }
        }
    }

    private void fillList() {
        try {
            Scanner scanner = new Scanner(new File("./src/com/company/day06/input.txt"));
            StringBuilder entity = new StringBuilder();
            List<String> list = new ArrayList<>();
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    input.add(entity.toString());
                    input2.add(list);
                    entity = new StringBuilder();
                    list = new ArrayList<>();
                    continue;
                }
                    entity.append(line);
                    list.add(line);
            }
            input.add(entity.toString());
            input2.add(list);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
