package com.dev.leetcode;

import java.util.HashMap;

public class AreOccurencesEqual {

    public static boolean areOccurrencesEqual(String s) {
        if(s.length() == 1)
            return true;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        int count = map.get(s.charAt(0));

        for(int i : map.values()) {
            if(i != count)
                return false;
        }

        return true;

    }

    public static void main(String[] args) {
        String input = "abacbc";
        System.out.println(areOccurrencesEqual(input));
        input = "aaabb";
        System.out.println(areOccurrencesEqual(input));
    }
}
