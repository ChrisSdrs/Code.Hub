package com.siderischr;

public class Main {

    public static void main(String[] args) {

        digitCounter(56);

    }

    public static void digitCounter(int num){
        int count = 0;
        while (num != 0) {
            // num = num/10
            num /= 10;
            count++;
        }
        System.out.println("Number of digits: " + count);
    }
}
