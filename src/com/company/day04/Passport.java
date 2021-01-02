package com.company.day04;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Passport {
    private final static List<String> eclList = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");

    private int byr = 0;
    private int iyr = 0;
    private int eyr = 0;
    private String hgt = "";
    private String hcl = "";
    private String ecl = "";
    private String pid = "";
    private final boolean isValid;

    public Passport(Map<String, String> map) {
        setValues(map);
        isValid = checkValidity();
    }

    public boolean getIsValid() {
        return this.isValid;
    }

    private boolean checkValidity() {
        return (checkByr() && checkIyr() && checkEyr() && checkHgt() && checkHcl() && checkEcl() && checkPid());
    }

    private boolean checkByr() {
        return (byr >= 1920 && byr <= 2002);
    }

    private boolean checkIyr() {
        return (iyr >= 2010 && iyr <= 2020);
    }

    private boolean checkEyr() {
        return (eyr >= 2020 && eyr <= 2030);
    }

    private boolean checkHgt() {
        if (hgt.endsWith("cm") && hgt.length() == 5) {
            return Integer.parseInt(hgt.substring(0, 3)) >= 150 && Integer.parseInt(hgt.substring(0, 3)) <= 193;
        } else if (hgt.endsWith("in") && hgt.length() == 4) {
            return Integer.parseInt(hgt.substring(0, 2)) >= 59 && Integer.parseInt(hgt.substring(0, 2)) <= 76;
        }
        return false;
    }

    private boolean checkHcl() {
        return (hcl.length() == 7 && hcl.matches("^#{1}[0-9a-f]{6}$"));
    }

    private boolean checkEcl() {
        return (ecl.length() == 3 && eclList.contains(ecl));
    }

    private boolean checkPid() {
        return (pid.length() == 9 && pid.matches("^[0-9]{9}$"));
    }

    private void setValues(Map<String, String> map) {
        if (map.size() < 7) return;

        if (map.get("byr") != null) {
            try {
                this.byr = Integer.parseInt(map.get("byr"));
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        if (map.get("iyr") != null) {
            try {
                this.iyr = Integer.parseInt(map.get("iyr"));
            } catch (Exception e) {
            System.out.println(e.toString());
        }
        }

        if (map.get("eyr") != null) {
            try {
                this.eyr = Integer.parseInt(map.get("eyr"));
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        if (map.get("hgt") != null) {
            this.hgt = map.get("hgt");
        }

        if (map.get("hcl") != null) {
            this.hcl = map.get("hcl");
        }

        if (map.get("ecl") != null) {
            this.ecl = map.get("ecl");
        }

        if (map.get("pid") != null) {
            this.pid = map.get("pid");
        }
    }
}
