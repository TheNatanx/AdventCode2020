package com.company.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day01 {
    private int firstAnswer, secondAnswer;

    public Day01() {
        List<Integer> inputList = new ArrayList<>();
        fulfillInputList(inputList);
        solveFirstPuzzle(inputList);
        solveSecondPuzzle(inputList);
        System.out.println("Les réponses pour la première et seconde étoile du jour 01 sont respectivement " + firstAnswer + " et " + secondAnswer);
    }

    private void solveFirstPuzzle(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                if (list.get(i) + list.get(j) == 2020) {
                    this.firstAnswer = list.get(i) * list.get(j);
                    return;
                }
            }
        }
    }

    private void solveSecondPuzzle(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                for (int k =0; k < list.size(); k++) {
                    if ((i == j) || (i == k) || (j == k)) continue;
                    if (list.get(i) + list.get(j) + list.get(k) == 2020) {
                        this.secondAnswer = list.get(i) * list.get(j) * list.get(k);
                        return;
                    }
                }
            }
        }
    }

    private void fulfillInputList(List<Integer> list) {
        try {
            Scanner scanner = new Scanner(new File("./src/com/company/day01/input.txt"));
            while (scanner.hasNextLine()) {
                list.add(Integer.parseInt(scanner.nextLine()));
            }
            scanner.close();
        } catch  (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getFirstAnswer() {
        return firstAnswer;
    }

    public int getSecondAnswer() {
        return secondAnswer;
    }
}
