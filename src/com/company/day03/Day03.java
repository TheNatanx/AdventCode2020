package com.company.day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day03 {
    private final List<String> lines = new ArrayList<>();
    int firstAnswer;
    int secondAnswer;
    int[][] couples = {{1, 1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}};

    public Day03() {
        fillList();
        firstAnswer = computeSlope(3, 1);
        secondAnswer = multiplyAnswers();
        System.out.println("Les réponses pour la première et seconde étoile du jour 03 sont respectivement " + firstAnswer + " et " + secondAnswer);
    }

    private int computeSlope(int xShift, int yShift) {
        int posOnLine = 0;
        int treeNb = 0;
        for (int i = 0; i < lines.size(); i += yShift) {
            if (!((lines.get(i).length() -1) - posOnLine >= 0)) {
                posOnLine = Math.abs((lines.get(i).length() -1) - posOnLine) - 1;
            }
            if (lines.get(i).charAt(posOnLine) == '#') {
                treeNb++;
            }
            posOnLine += xShift;
        }
        return treeNb;
    }

    private int multiplyAnswers() {
        int answer = 1;
        for (int i = 0; i < couples.length; i++) {
            answer *= computeSlope(couples[i][0], couples[i][1]);
        }
        return answer;
    }

    private void fillList() {
        try {
            Scanner scanner = new Scanner(new File("C:/Users/Nath/Documents/AdventCode2020/src/com/company/day03/input.txt"));
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                lines.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
