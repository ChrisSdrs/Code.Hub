package com.siderischr;

public class Main {

    public static void main(String[] args) {

        getDecimal(2.31f);



    }

    public static void getDecimal (float fNum) {
        int iNum = (int) fNum;
        System.out.println("Float number: " + fNum);
        System.out.println("Integer part: " + iNum);
        System.out.println("Decimal part: " + (fNum - iNum));

    }
}
