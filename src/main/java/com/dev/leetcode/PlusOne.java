package com.dev.leetcode;

import java.math.BigInteger;
import java.util.Arrays;

public class PlusOne {

    /**
     * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
     * The digits are ordered from most significant to least significant in left-to-right order.
     * The large integer does not contain any leading 0's.
     * Increment the large integer by one and return the resulting array of digits.
     */
    public int[] plusOneFromLeetcodeSolution(int[] digits)
    {
        for(int i=digits.length-1;i>=0;i--)
        {
            if(digits[i]!=9)
            {
                digits[i]++;
                return digits;
            }
            else
            {
                digits[i]=0;
            }
        }

        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;

    }

    public static int[] plusOne(int[] digits) {
        BigInteger number = BigInteger.ZERO;
        for(int i = digits.length - 1; i >= 0; i--) {
            number = number.add(BigInteger.valueOf(digits[(digits.length - 1) - i]).multiply(BigInteger.TEN.pow(i)));
        }

        number = number.add(BigInteger.ONE); // plus 1
        System.out.println(number);

        String plusOneString = number + "";
        int[] result = new int[plusOneString.length()];

        for(int i = 0; i < result.length; i++) {
            result[i] = Character.getNumericValue(plusOneString.charAt(i));
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int[] digits = {1,2,3};
        plusOne(digits);
        digits = new int[]{9, 9, 9};
        plusOne(digits);
        digits = new int[]{9,8,7,6,5,4,3,2,1,0};
        plusOne(digits);
        digits = new int[]{6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        plusOne(digits);
    }
}
