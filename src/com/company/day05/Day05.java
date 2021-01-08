package com.company.day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day05 {
    private final List<String> input = new ArrayList<>();
    private final List<Integer> rows = fillSeats(128);
    private final List<Integer> columns = fillSeats(8);
    private final List<Integer> ids = new ArrayList<>();
    private int firstAnswer = 0;
    private int secondAnswer = 0;

    public Day05() {
        fillList();
        firstStar();
        secondStar();
        System.out.println("Les réponses pour la première et seconde étoile du jour 05 sont respectivement " + firstAnswer + " et " + secondAnswer);
    }

    private void firstStar() {
        List<Integer> tmpRows = rows;
        List<Integer> tmpColumns = columns;
        for (String seatPlace : input) {
            for (int i = 0; i < seatPlace.length(); i++) {
                if (i < 7) {
                    tmpRows = splitList(String.valueOf(seatPlace.charAt(i)), tmpRows);
                } else {
                    tmpColumns = splitList(String.valueOf(seatPlace.charAt(i)), tmpColumns);
                }
                if (tmpRows.size() == 1 && tmpColumns.size() == 1) {
                    int id = (tmpRows.get(0) * 8) + tmpColumns.get(0);
                    ids.add(id);
                    if (id > firstAnswer) {
                        firstAnswer = id;
                    }
                }
            }
            tmpColumns = columns;
            tmpRows = rows;
        }
    }

    private void secondStar(){
        Collections.sort(ids);
        for (int i = 0; i < ids.size(); i++) {
            if ((ids.get(i + 1)) != (ids.get(i) + 1)) {
                secondAnswer = ids.get(i) + 1;
                return;
            }
        }
    }

    private void fillList() {
        try {
            Scanner scanner = new Scanner(new File("./src/com/company/day05/input.txt"));
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

    private List<Integer> splitList(String letter, List<Integer> nb) {
        List<Integer> firstHalf = new ArrayList<>(nb.subList(0, (nb.size() + 1)/2));
        List<Integer> secondHalf = new ArrayList<>(nb.subList((nb.size() + 1)/2, nb.size()));
        if (letter.equals("F") || letter.equals("L")) {
            return firstHalf;
        } else {
            return secondHalf;
        }
    }

    private List<Integer> fillSeats(int nb) {
        List<Integer> toReturn = new ArrayList<>();
        for (int i = 0; i < nb; i++) {
            toReturn.add(i);
        }
        return toReturn;
    }
}
