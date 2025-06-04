package com.dev.leetcode.hard;

import java.util.ArrayList;

public class MaximumCandies {

    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int maxCandies = 0;
        ArrayList<Integer> totalKeys = new ArrayList<>();
        ArrayList<Integer> closedBoxes = new ArrayList<>();

        for (int initialBox : initialBoxes) {
            if (status[initialBox] == 1) {
                maxCandies += candies[initialBox];
            }

            for (int key : keys[initialBox]) {
                totalKeys.add(key);
            }

            for (int containedBox : containedBoxes[initialBox]) {
                if (status[containedBox] == 1) {
                    maxCandies += candies[containedBox];
                    for (int key : keys[containedBox]) {
                        totalKeys.add(key);
                    }

                    for (int containedBoxInner : containedBoxes[containedBox]) {
                        if (status[containedBoxInner] == 1) {
                            maxCandies += candies[containedBoxInner];
                            for (int key : keys[containedBoxInner]) {
                                totalKeys.add(key);
                            }
                        } else {
                            closedBoxes.add(containedBoxInner);
                        }
                    }
                } else {
                    closedBoxes.add(containedBox);
                }
            }
        }

        int counter = 0;
        while (counter < closedBoxes.size()) {
            int closedBox = closedBoxes.get(counter);
            if (totalKeys.contains(closedBox)) {
                maxCandies += candies[closedBox];
                for (int key : keys[closedBox]) {
                    totalKeys.add(key);
                }

                for (int containedBoxInner : containedBoxes[closedBox]) {
                    if (status[containedBoxInner] == 1) {
                        maxCandies += candies[containedBoxInner];
                        for (int key : keys[containedBoxInner]) {
                            totalKeys.add(key);
                        }
                    } else {
                        closedBoxes.add(containedBoxInner);
                    }
                }
            }
            counter++;
        }

        return maxCandies;
    }

    public static void main(String[] args) {
        int[] status = {1,0,1,0};
        int[] candies = {7,5,4,100};
        int[][]  keys = {{}, {},{1}, {}};
        int[][] containedBoxes = {{1,2},{3}, {}, {}};
        int[] initialBoxes = {0};

        System.out.println(maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }
}
