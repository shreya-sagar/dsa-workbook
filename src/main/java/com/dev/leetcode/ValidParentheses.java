package com.dev.leetcode;

import java.util.HashMap;
import java.util.Objects;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s.length() == 1)
            return false;

        String b1 = "()";
        if (s.equals(b1))
            return true;

        String b2 = "{}";
        if (s.equals(b2))
            return true;

        String b3 = "[]";
        if (s.equals(b3))
            return true;

        HashMap<String, Integer> bracketOpenMap = new HashMap<>();
        HashMap<String, Integer> bracketClosedMap = new HashMap<>();

        int i = 0;
        int length = s.length();
        while (i < length) {

            if (i == length - 1) {
                String temp = s.charAt(i) + "";
                if (temp.equals("(") || temp.equals("{") || temp.equals("[")) {
                    if (Objects.nonNull(bracketOpenMap.get(temp)))
                        bracketOpenMap.put(temp, bracketOpenMap.get(temp) + i);
                    else
                        bracketOpenMap.put(temp, i);
                } else if (temp.equals(")") || temp.equals("}") || temp.equals("]")) {
                    if (Objects.nonNull(bracketClosedMap.get(temp)))
                        bracketClosedMap.put(temp, bracketClosedMap.get(temp) + (length - 1 - i));
                    else
                        bracketClosedMap.put(temp, (length - 1 - i));
                }

                i++;
            } else {
                String charAti = s.charAt(i) + "";
                String charAtNext = s.charAt(i + 1) + "";
                String valid = charAti + charAtNext;

                if (valid.equals(b1) || valid.equals(b2) || valid.equals(b3)) {
                    i = i + 2;
                } else {
                    String temp = s.charAt(i) + "";
                    if (temp.equals("(") || temp.equals("{") || temp.equals("[")) {
                        if (Objects.nonNull(bracketOpenMap.get(temp)))
                            bracketOpenMap.put(temp, bracketOpenMap.get(temp) + i);
                        else
                            bracketOpenMap.put(temp, i);
                    } else if (temp.equals(")") || temp.equals("}") || temp.equals("]")) {
                        if (Objects.nonNull(bracketClosedMap.get(temp)))
                            bracketClosedMap.put(temp, bracketClosedMap.get(temp) + (length - 1 - i));
                        else
                            bracketClosedMap.put(temp, (length - 1 - i));
                    }
                    i++;
                }
            }
        }

        if (bracketOpenMap.isEmpty() && bracketClosedMap.isEmpty())
            return true;
        else
            return Objects.equals(bracketOpenMap.get("("), bracketClosedMap.get(")"))
                && Objects.equals(bracketOpenMap.get("{"), bracketClosedMap.get("}"))
                && Objects.equals(bracketOpenMap.get("["), bracketClosedMap.get("]"));

    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
        s = "(]";
        System.out.println(isValid(s));
        s = "([])";
        System.out.println(isValid(s));
        s = "(}{)";
        System.out.println(isValid(s));
    }
}
