package com.siderischr;

public class Main {

    public static void main(String[] args) {
        int num = 3;
        long factorial = 1;
        for(int i = 1; i <= num; i++)
        {
            // factorial = factorial * i;
            factorial *= i;
        }
        System.out.println("Factorial of " + num + " = " + factorial);
    }
}
