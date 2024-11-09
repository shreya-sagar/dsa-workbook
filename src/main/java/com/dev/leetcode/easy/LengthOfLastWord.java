package com.dev.leetcode.easy;

public class LengthOfLastWord {

    /**
     * Given a string s consisting of words and spaces, return the length of the last word in the string.
     * A word is a maximal substring consisting of non-space characters only.
     */
    public static int lengthOfLastWord(String s) {
        String input = s.trim();
        int lastIndex = input.length() - 1;
        int indexOfLastSpace = input.lastIndexOf(" ");
        int length = 0;
        if (indexOfLastSpace > 0)
            length = lastIndex - indexOfLastSpace;
        else
            length = input.length();

        return length;
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
        s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
        s = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(s));

    }

}
