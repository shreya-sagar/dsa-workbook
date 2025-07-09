package com.dev.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LexSmallestEquivalentString {

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        StringBuilder output = new StringBuilder();

        ArrayList<StringBuilder> groups = new ArrayList<>();
        HashMap<Character, Integer> indexOfGroups = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            int nextGroupsIndex = indexOfGroups.size();
            //StringBuilder equivalent = new StringBuilder();
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            Integer charIndex;

            if (indexOfGroups.get(ch1) != null && indexOfGroups.get(ch2) != null
                    && !indexOfGroups.get(ch1).equals(indexOfGroups.get(ch2))) {
                charIndex = Math.min(indexOfGroups.get(ch1), indexOfGroups.get(ch2));
            } else {
                charIndex = indexOfGroups.get(ch1) != null ? indexOfGroups.get(ch1) : indexOfGroups.get(ch2);
            }

            if (charIndex == null) {
                if (ch1 == ch2) {
//                    equivalent.append(ch1);
                    indexOfGroups.put(ch1, nextGroupsIndex);
                } else {
//                    equivalent.append(ch1);
//                    equivalent.append(ch2);
                    indexOfGroups.put(ch1, nextGroupsIndex);
                    indexOfGroups.put(ch2, nextGroupsIndex);

//                    char[] equivalentArray = equivalent.toString().toCharArray();
//                    Arrays.sort(equivalentArray);
//                    equivalent = new StringBuilder(new String(equivalentArray));
                }

                //groups.add(nextGroupsIndex, equivalent);
            } else if (ch1 != ch2) {
                //equivalent = groups.get(charIndex);
                if(indexOfGroups.get(ch1) != null && indexOfGroups.get(ch2) != null) {

                    if(charIndex < indexOfGroups.get(ch1)) {
                        //equivalent.append(ch1);
                        indexOfGroups.put(ch1, charIndex);
                    } else {
                        //equivalent.append(ch2);
                        indexOfGroups.put(ch2, charIndex);
                    }
                } else if (indexOfGroups.get(ch1) != null) {
                    //equivalent.append(ch2);
                    indexOfGroups.put(ch2, charIndex);
                } else {
                    //equivalent.append(ch1);
                    indexOfGroups.put(ch1, charIndex);
                }
//                char[] equivalentArray = equivalent.toString().toCharArray();
//                Arrays.sort(equivalentArray);
//                equivalent = new StringBuilder(new String(equivalentArray));
//
//                groups.set(charIndex, equivalent);
            }
        }

        for(Map.Entry<Character, Integer> entry : indexOfGroups.entrySet()) {
            System.out.println(entry);

            Integer index = entry.getValue();
            if(!groups.isEmpty()) {
                StringBuilder equivalent = groups.get(index);
                equivalent.append(entry.getKey());
                char[] equivalentArray = equivalent.toString().toCharArray();
                Arrays.sort(equivalentArray);
                equivalent = new StringBuilder(new String(equivalentArray));

                groups.set(index, equivalent);
            } else {
                groups.add(new StringBuilder().append(entry.getKey()));
            }
            System.out.println(groups);
        }

        System.out.println(groups);
        System.out.println(indexOfGroups);

        for (int i = 0; i < baseStr.length(); i++) {
            Integer indexOfChar = indexOfGroups.get(baseStr.charAt(i));
            if (indexOfChar != null)
                output.append(groups.get(indexOfChar).toString().charAt(0));
            else
                output.append(baseStr.charAt(i));
        }

        return output.toString();
    }
    /*public static String smallestEquivalentString(String s1, String s2, String baseStr) {

        StringBuilder output = new StringBuilder();

        ArrayList<StringBuilder> groups = new ArrayList<>();
        HashMap<Character, Integer> indexOfGroups = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            System.out.println(groups);
            System.out.println(indexOfGroups);

            int nextGroupsIndex = groups.size();
            StringBuilder equivalent = new StringBuilder();
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            Integer charIndex;
            int indexToBeRemoved;

            if(indexOfGroups.get(ch1) != null && indexOfGroups.get(ch2) != null && !indexOfGroups.get(ch1).equals(indexOfGroups.get(ch2))) {
                StringBuilder temp;
                if(indexOfGroups.get(ch1) < indexOfGroups.get(ch2)) {
                    charIndex = indexOfGroups.get(ch1);
                    temp = groups.get(indexOfGroups.get(ch2));
                    indexToBeRemoved = indexOfGroups.get(ch2);
                    groups.remove(indexToBeRemoved);
                    equivalent = groups.get(indexOfGroups.get(ch1));
                    equivalent.append(temp);
                } else {
                    charIndex = indexOfGroups.get(ch2);
                    temp = groups.get(indexOfGroups.get(ch1));
                    indexToBeRemoved = indexOfGroups.get(ch1);
                    groups.remove(indexToBeRemoved);
                    equivalent = groups.get(indexOfGroups.get(ch2));
                    equivalent.append(temp);
                }

                for (int j = 0; j < temp.length(); j++) {
                    indexOfGroups.put(temp.charAt(j), charIndex);
                }

                StringBuilder shift = new StringBuilder();
                for (int j = indexToBeRemoved; j < groups.size(); j++) {
                    shift.append(groups.get(j));
                }

                for (int k = 0; k < shift.length(); k++) {
                    indexOfGroups.put(shift.charAt(k), indexOfGroups.get(shift.charAt(k)) - 1);
                }


                char[] equivalentArray = equivalent.toString().toCharArray();
                Arrays.sort(equivalentArray);
                equivalent = new StringBuilder(new String(equivalentArray));

                groups.set(charIndex, equivalent);
                continue;
            } else {
                charIndex = indexOfGroups.get(ch1) != null ? indexOfGroups.get(ch1) : indexOfGroups.get(ch2);
            }


            if (charIndex == null) {
                if (ch1 == ch2) {
                    equivalent.append(ch1);
                    indexOfGroups.put(ch1, nextGroupsIndex);
                } else {
                    equivalent.append(ch1);
                    equivalent.append(ch2);
                    indexOfGroups.put(ch1, nextGroupsIndex);
                    indexOfGroups.put(ch2, nextGroupsIndex);

                    char[] equivalentArray = equivalent.toString().toCharArray();
                    Arrays.sort(equivalentArray);
                    equivalent = new StringBuilder(new String(equivalentArray));
                }

                groups.add(nextGroupsIndex, equivalent);
            } else if (ch1 != ch2) {
                System.out.println("ch1 " + ch1);
                System.out.println("ch2 " + ch1);
                System.out.println(charIndex);
                equivalent = groups.get(charIndex);
                if (indexOfGroups.get(ch1) != null) {
                    equivalent.append(ch2);
                    indexOfGroups.put(ch2, charIndex);
                } else {
                    equivalent.append(ch1);
                    indexOfGroups.put(ch1, charIndex);
                }
                char[] equivalentArray = equivalent.toString().toCharArray();
                Arrays.sort(equivalentArray);
                equivalent = new StringBuilder(new String(equivalentArray));

                groups.set(charIndex, equivalent);
            }
        }

        System.out.println(groups);
        System.out.println(indexOfGroups);

        for (int i = 0; i < baseStr.length(); i++) {
            Integer indexOfChar = indexOfGroups.get(baseStr.charAt(i));
            if (indexOfChar != null)
                output.append(groups.get(indexOfChar).toString().charAt(0));
            else
                output.append(baseStr.charAt(i));
        }

        return output.toString();
    }*/

    public static void main(String[] args) {
        String s1 = "ceihfgechfcbjhadaibhghcbdhfaecdaijigaaafcadebciabb";
        String s2 = "gafbfceidigjceeigcddichdhhbgibjbaagbfciiecjaiajahh";
        String baseStr = "eoiloytuagirigmbarebhzgveiavyruxlrxzbommyfjjngfktd";

        System.out.println(smallestEquivalentString(s1, s2, baseStr));
    }
}
