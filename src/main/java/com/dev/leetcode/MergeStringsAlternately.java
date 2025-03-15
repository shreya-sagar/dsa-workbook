package com.dev.leetcode;

public class MergeStringsAlternately {
    public static String mergeAlternately(String word1, String word2) {
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();

        String result = "";

        if(word1.length() < word2.length()) {
            for(int i = 0; i < word1.length(); i++) {
                result = result + word1.charAt(i) + word2.charAt(i);
            }
            result = result + word2.substring(word1.length());
        } else if(word2.length() < word1.length()) {
            for(int i = 0; i < word2.length(); i++) {
                result = result + word1.charAt(i) + word2.charAt(i);
            }
            result = result + word1.substring(word2.length());
        } else {
            for(int i = 0; i < word1.length(); i++) {
                result = result + word1.charAt(i) + word2.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String word1="abc";
        String word2="pqr";
        System.out.println(mergeAlternately(word1,word2));
        word1="ab";
        word2="pqrs";
        System.out.println(mergeAlternately(word1,word2));
        word1="abcd";
        word2="pq";
        System.out.println(mergeAlternately(word1,word2));
    }
}
