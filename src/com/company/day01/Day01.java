package com.company.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        int n = 2020;
        HashSet<Integer> set = list.stream()
                .filter(x -> x <= n >> 1)
                .map(x -> n - x)
                .collect(Collectors.toCollection(HashSet::new));
        set.retainAll(new HashSet<>(list));
        firstAnswer = set.stream().findFirst().map(x -> (n - x) * x).orElse(0);
    }

    private void solveSecondPuzzle(List<Integer> list) {
        List<Integer[]> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int t = 2020 - list.get(i);
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < list.size(); j++) {
                if (set.contains(t - list.get(j))) {
                    result.add(new Integer[]{list.get(i), list.get(j), t - list.get(j)});
                } else {
                    set.add(list.get(j));
                }
            }
        }
        secondAnswer = result.stream().flatMap(Stream::of).reduce(1, (a, b) -> a * b);
    }

    private void fulfillInputList(List<Integer> list) {
        try {
            Scanner scanner = new Scanner(new File("./src/com/company/day01/input.txt"));
            while (scanner.hasNextLine()) {
                list.add(Integer.parseInt(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
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
