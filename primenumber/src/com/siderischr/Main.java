package com.siderischr;

public class Main {

    public static void main(String[] args) {

        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(5));
        System.out.println(isPrime(8));
        System.out.println(isPrime(9));
        System.out.println(isPrime(61));
        System.out.println(isPrime(63));


    }

    public static boolean isPrime(int number){

        for (int i = 2; i < number; i++)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
