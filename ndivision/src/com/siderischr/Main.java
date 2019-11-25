package com.siderischr;

public class Main {

    public static void main(String[] args) {

        System.out.println(sum(5));


    }

    public static double sum(int n) {
        double result = 0;
        for (double i = 0; i < n; i++)
        {
            result=result+1.0/(i+1);
        }
        return result;
    }
}
