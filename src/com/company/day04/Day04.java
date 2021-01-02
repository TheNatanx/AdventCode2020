package com.company.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day04 {
    private final List<String> entities = new ArrayList<>();
    private final List<Passport> passports = new ArrayList<>();
    int firstAnswer = 0;
    int secondAnswer = 0;

    public Day04() {
        fillList();
        firstStar();
        secondStar();
        System.out.println("Les réponses pour la première et seconde étoile du jour 04 sont respectivement " + firstAnswer + " et " + secondAnswer);
    }

    private void firstStar() {
        for (String entity : entities) {
            if (
                entity.contains("byr") &&
                entity.contains("iyr") &&
                entity.contains("eyr") &&
                entity.contains("hgt") &&
                entity.contains("hcl") &&
                entity.contains("ecl") &&
                entity.contains("pid")) {
                firstAnswer += 1;
            }
        }
    }

    private void secondStar() {
        List<Map<String, String>> maps = new ArrayList<>();
        for (String entity : entities) {
            Map<String, String> map = new HashMap<>();
            String[] couples = entity.split(" ");
            for (String couple : couples) {
                String[] keyValue = couple.split(":");
                map.put(keyValue[0], keyValue[1]);
            }
            maps.add(map);
        }
        fillPassports(maps);
        for (Passport passport : passports) {
            if(passport.getIsValid()) {
                secondAnswer++;
            }
        }
    }

    private void fillPassports(List<Map<String, String>> maps) {
        for (Map<String, String> map : maps) {
            passports.add(new Passport(map));
        }
    }

    private void fillList() {
        try {
            Scanner scanner = new Scanner(new File("C:/Users/Nath/Documents/AdventCode2020/src/com/company/day04/input.txt"));
            StringBuilder entity = new StringBuilder();
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    entities.add(entity.toString());
                    entity = new StringBuilder();
                    continue;
                }
                if (entity.length() == 0) {
                    entity.append(line);
                } else {
                    entity.append(" ").append(line);
                }
            }
            entities.add(entity.toString());
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
