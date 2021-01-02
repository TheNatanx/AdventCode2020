package com.company;

import com.company.day01.Day01;
import com.company.day02.Day02;
import com.company.day03.Day03;
import com.company.day04.Day04;
import com.company.day05.Day05;
import com.company.day06.Day06;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        long start = new Date().getTime();
        new Day01();
        new Day02();
        new Day03();
        new Day04();
        new Day05();
        new Day06();
        long finish = new Date().getTime();
        System.out.println("(Ce code a été exécuté en " + (finish - start) + " millisecondes.)");
    }
}
