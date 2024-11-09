package com.dev.leetcode.easy;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class RomanToInteger {
    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII.
     * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX.
     *
     * There are six instances where subtraction is used:
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     *
     * Given a roman numeral, convert it to an integer.
     */
    public static int romanToInt(String s) {
        int value = 0;

        HashMap<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);

        HashMap<String, Integer> romanSubtraction = new HashMap<>();
        romanSubtraction.put("IV", 4);
        romanSubtraction.put("IX", 9);
        romanSubtraction.put("XL", 40);
        romanSubtraction.put("XC", 90);
        romanSubtraction.put("CD", 400);
        romanSubtraction.put("CM", 900);

        if (s.length() == 1) {
            value = roman.get(String.valueOf(s.charAt(0)));
            return value;
        }

        int i = 0;
        while (i < s.length()) {

            if (i == s.length() - 1) {
                value = value + roman.get(String.valueOf(s.charAt(i)));
                i++;
            } else {
                String section = String.valueOf(s.charAt(i)) + s.charAt(i + 1);
                Optional<String> subKeyOptional = romanSubtraction.keySet()
                        .stream()
                        .filter(x -> x.equals(section)).findFirst();
                String subKey = subKeyOptional.orElse(null);
                if (Objects.nonNull(subKey)) {
                    value = value + romanSubtraction.get(subKey);
                    i = i + 2;
                } else {
                    value = value + roman.get(String.valueOf(s.charAt(i)));
                    i++;
                }
            }

        }
        return value;
    }

    // Picked from Submissions
    public int romanToIntOptimized(String s) {

        int answer = 0, number = 0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }

    public static void main(String[] args) {
        String input = "III";
        System.out.println(input + " : "+ romanToInt(input));
        input = "LVIII";
        System.out.println(input + " : "+ romanToInt(input));
        input = "MCMXCIV";
        System.out.println(input + " : "+ romanToInt(input));
    }
}
