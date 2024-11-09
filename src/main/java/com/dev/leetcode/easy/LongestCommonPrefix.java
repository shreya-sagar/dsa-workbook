package com.dev.leetcode.easy;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs.length == 1) {
            prefix = new StringBuilder(strs[0]);
        } else {
            int i;
            int j = 0;
            int leastLength = 200;

            for (String s : strs) {
                if (s.length() < leastLength)
                    leastLength = s.length();
            }

            while (j < leastLength) {
                i = 1;
                while (i < strs.length) {
                    if (strs[i].charAt(j) != strs[i - 1].charAt(j)) {
                        j = leastLength;
                        break;
                    }
                    i++;
                }
                if (i == strs.length)
                    prefix.append(strs[0].charAt(j));
                j++;
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"dog", "racecar", "car"};
        System.out.println(Arrays.toString(strs) + " longestCommonPrefix: " + longestCommonPrefix(strs));
        strs = new String[]{"flower", "flow", "flight"};
        System.out.println(Arrays.toString(strs) + " longestCommonPrefix: " + longestCommonPrefix(strs));
    }
}
