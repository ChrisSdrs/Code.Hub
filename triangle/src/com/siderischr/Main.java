package com.siderischr;

public class Main {

    public static void main(String[] args) {

        perimeter(2,3,5,7,4,9);

    }

    public static void perimeter (int x1, int y1, int x2, int y2, int x3, int y3){

        // Used the method: d = (((x2-x1)^2) + ((y2-y1)^2))^(-2)
        double firstSide = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2 - y1), 2));
        double secondSide = Math.sqrt(Math.pow((x3-x1), 2) + Math.pow((y3 - y1), 2));
        double thirdSide = Math.sqrt(Math.pow((x3-x2), 2) + Math.pow((y3 - y2), 2));

        System.out.println("Perimeter is: " + (firstSide + secondSide + thirdSide));
    }
}