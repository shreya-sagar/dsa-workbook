package com.dev.recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static Integer factorial(int n) {
        if(n == 1) return 1;
        return n * factorial(n-1);
    }
}
