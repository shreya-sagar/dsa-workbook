package com.dev.leetcode.easy;

import java.util.*;

public class IsomorphicStrings {

    /**
     * Given two strings s and t, determine if they are isomorphic.
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
     * All occurrences of a character must be replaced with another character while preserving the order of characters.
     * No two characters may map to the same character, but a character may map to itself.
     * Example 1:
     * Input: s = "egg", t = "add"
     * Output: true
     * Explanation:
     * The strings s and t can be made identical by:
     * Mapping 'e' to 'a'.
     * Mapping 'g' to 'd'.
     */
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() == 1)
            return true;

        LinkedHashMap<String, Integer> smap = new LinkedHashMap<>();
        for (int j = 0; j < s.length(); j++) {
            String element = s.charAt(j) + "";
            if(Objects.nonNull(smap.get(element))) {
                int value = smap.get(element);
                smap.put(element, value + j);
            }
            else {
                smap.put(element, j);
            }
        }

        LinkedHashMap<String, Integer> tmap = new LinkedHashMap<>();
        for (int j = 0; j < t.length(); j++) {
            String element = t.charAt(j) + "";
            if(Objects.nonNull(tmap.get(element))) {
                int value = tmap.get(element);
                tmap.put(element, value + j);
            }
            else {
                tmap.put(element, j);
            }
        }

        List<Integer> smapValues = smap.values().stream().toList();
        List<Integer> tmapValues = tmap.values().stream().toList();

        return smapValues.equals(tmapValues);
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s,t));
        s = "foo";
        t = "bar";
        System.out.println(isIsomorphic(s,t));
        s = "paper";
        t = "title";
        System.out.println(isIsomorphic(s,t));
        s = "badc";
        t = "baba";
        System.out.println(isIsomorphic(s,t));
        s = "foo";
        t = "app";
        System.out.println(isIsomorphic(s,t));
        s = "abcdefghijklmnopqrstuvwxyzva";
        t = "abcdefghijklmnopqrstuvwxyzck";
        System.out.println(isIsomorphic(s,t));
        s = "aaabbbcccaaabbbccc";
        t = "aaabbbcccbbbaaaccc";
        System.out.println(isIsomorphic(s,t));
    }
}
