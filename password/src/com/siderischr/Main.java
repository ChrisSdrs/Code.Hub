package com.siderischr;


import javax.xml.stream.events.Characters;

public class Main {

    public static void main(String[] args) {

        // In order to test most of the cases call test();
        // Else write a password calling passwordCheck("enter your password")

        test();

    }

    public static void passwordCheck(String password) {
        int count = 0;
        if (password.length() < 8) {
            count++;
        }
        if (!lowerCaseCheck(password) || !upperCaseCheck(password)) {
            count++;
        }
        if (!numberCheck(password)) {
            count++;
        }
        if (!specialCharCheck(password)) {
            count++;
        }
        if (!sameCharCheck(password)) {
            count++;
        }
        if (!threeConsecutiveCharCheck(password)) {
            count++;
        }
        if (count == 0) {
            System.out.println("OLAPOPA");
        } else
            System.out.println(count);

    }


    public static boolean lowerCaseCheck(String password) {
        if (password == password.toLowerCase()) {
            return false;
        } else return true;
    }

    public static boolean upperCaseCheck(String password) {
        if (password == password.toUpperCase()) {
            return false;
        } else return true;
    }

    public static boolean numberCheck(String password) {
        for (int i = 0; i <= 9; i++) {
            if (password.contains(String.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean specialCharCheck(String password) {
        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
        for (int i = 0; i < password.length(); i++) {
            for (int z = 0; z < specialCharacters.length(); z++) {
                if (password.charAt(i) == specialCharacters.charAt(z)) {
                    return true;
                }
            }
        }
        return false;

        //        String[] str2 =specialCharacters.split("");
//        for (int i=0;i<str2.length;i++) {
//            if (password.contains(str2[i]))
//            {
//                return true;
//            }
//        } return false;
    }

    public static boolean sameCharCheck(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i + 1) == password.charAt(i + 2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean threeConsecutiveCharCheck(String password) {
        password = password.toLowerCase();
        boolean contains = true;
        String currentChar = "";
        String previousChar = "";
        int countDirect = 1;
        int countReverse = 1;
        int previousCharNumber = 0;
        int currentCharNumber = 0;
        while (password.length() > 0) {
            currentChar = password.substring(0, 1);
            previousCharNumber = getNumberOfChar(previousChar);
            currentCharNumber = getNumberOfChar(currentChar);

            if (currentCharNumber == previousCharNumber + 1) {
                countDirect++;
            } else {
                countDirect = 1;
            }

            if (currentCharNumber == previousCharNumber - 1) {
                countReverse++;
            } else {
                countReverse = 1;
            }
            previousChar = currentChar;

            if (countDirect == 3 || countReverse == 3) {
                contains = false;
                break;
            }

            password = password.substring(1);
        }

        return contains;
    }

    public static int getNumberOfChar(String character) {
        boolean found = false;
        int foundIndex = -1;
        String[] characters = new String[26];
        characters[0] = "a";
        characters[1] = "b";
        characters[2] = "c";
        characters[3] = "d";
        characters[4] = "e";
        characters[5] = "f";
        characters[6] = "g";
        characters[7] = "h";
        characters[8] = "i";
        characters[9] = "j";
        characters[10] = "k";
        characters[11] = "l";
        characters[12] = "m";
        characters[13] = "n";
        characters[14] = "o";
        characters[15] = "p";
        characters[16] = "q";
        characters[17] = "r";
        characters[18] = "s";
        characters[19] = "t";
        characters[20] = "u";
        characters[21] = "v";
        characters[22] = "w";
        characters[23] = "x";
        characters[24] = "y";
        characters[25] = "z";

        int[] numbers = new int[40];
        numbers[30] = 0;
        numbers[31] = 1;
        numbers[32] = 2;
        numbers[33] = 3;
        numbers[34] = 4;
        numbers[35] = 5;
        numbers[36] = 6;
        numbers[37] = 7;
        numbers[38] = 8;
        numbers[39] = 9;
        String currentChar;
        for (int i = 0; i < characters.length; i++) {
            currentChar = characters[i];
            if (character.matches(currentChar)) {
                found = true;
                foundIndex = i;
                break;
            }
        }
        if (!found) {
            for (int i = 20; i < numbers.length; i++) {
                currentChar = String.valueOf(numbers[i]);
                if (character.matches(currentChar)) {
                    found = true;
                    foundIndex = i;
                    break;
                }
            }
        }
        if (found)
            return foundIndex;
        else
            //Return a value that is not within the tables
            return -2;
    }

    public static void test (){
        // Right password
        passwordCheck("A#a1@759");
        // Only lowercase
        passwordCheck("tgbdrplk");
        // Only uppercase
        passwordCheck("TGBDRPLK");
        // Only numbers
        passwordCheck("03867759");
        // Only special characters
        passwordCheck("*^$@&*$$%@");
        // Missing special characters
        passwordCheck("A25a1Lk759");
        // Missing numbers
        passwordCheck("A#a*@BtH");
        // Missing uppercase
        passwordCheck("k#a1@759");
        // Missing lowercase
        passwordCheck("A#91@759");
        // Missing special characters & numbers
        passwordCheck("ALaYlubT");
        // Missing special characters & uppercase
        passwordCheck("jba1&759");
        // Missing special characters & lowercase
        passwordCheck("AUB54NM759");
        // Missing numbers & uppercase
        passwordCheck("AG81L759");
        // Missing numbers & lowercase
        passwordCheck("A#TU@OKF");
        // Three same characters
        passwordCheck("A#aaa1@759");
        // Three same characters & only lowercase
        passwordCheck("hnctglopdddth");
        // Three same characters & only uppercase
        passwordCheck("HNCTTTGLOPDTH");
        // Three same characters & only numbers
        passwordCheck("19355578204");
        // Three same characters & only special characters
        passwordCheck("$&$@*&^%%%");
        // Three same characters & missing special characters
        passwordCheck("AXa1bbb759");
        // Three same characters & missing numbers
        passwordCheck("A#avvv@&&&");
        // Three same characters & missing uppercase
        passwordCheck("ο#a1@@@759");
        // Three same characters & missing lowercase
        passwordCheck("A#P111@759");
        // Three same characters & missing special characters & numbers
        passwordCheck("AAAamjTgU");
        // Three same characters & missing special characters & uppercase
        passwordCheck("5gggal9759");
        // Three same characters & missing special characters & lowercase
        passwordCheck("AKPV14444759");
        // Three same characters & missing numbers & uppercase
        passwordCheck("lll#anbg@*^");
        // Three same characters & missing numbers & lowercase
        passwordCheck("A#UNB@%^BBBT");
        // Three consecutive characters & only lowercase
        passwordCheck("hijpoklubv");
        // Three consecutive characters & only uppercase
        passwordCheck("KOMTGLMNO");
        // Three consecutive characters & only nubers
        passwordCheck("19356780");
        // Three consecutive characters & only special characters
        passwordCheck("%&^$#@*&%@#%^&");
        // Three consecutive characters & missing special characters
        passwordCheck("AbCa1Knm759");
        // Three consecutive characters & missing numbers
        passwordCheck("A#aB@stu");
        // Three consecutive characters & missing uppercase
        passwordCheck("n#a1@78959");
        // Three consecutive characters & missing lowercase
        passwordCheck("A#3WXY1@759");
        // Three consecutive characters & missing special characters & numbers
        passwordCheck("A#a1@759");
        // Three consecutive characters & missing special characters & uppercase
        passwordCheck("A#a1@759");
        // Three consecutive characters & missing special characters & lowercase
        passwordCheck("A#a1@759");
        // Three consecutive characters & missing numbers & uppercase
        passwordCheck("A#a1@759");
        // Three consecutive characters & missing numbers & lowercase
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters & only lowercase
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters & only uppercase
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters & only numbers
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters & only special characters
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters & missing special characters
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters & missing numbers
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters & missing uppercase
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters & missing lowercase
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters & missing special characters & numbers
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters & missing special characters & uppercase
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters & missing special characters & lowercase
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters & missing numbers & uppercase
        passwordCheck("A#a1@759");
        // Three consecutive characters & three same characters & missing numbers & lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters
        passwordCheck("A#a1@759");
        // Password < 8 characters & only lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & only uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & only numbers
        passwordCheck("A#a1@759");
        // Password < 8 characters & only special characters
        passwordCheck("A#a1@759");
        // Password < 8 characters & missing special characters
        passwordCheck("A#a1@759");
        // Password < 8 characters & missing numbers
        passwordCheck("A#a1@759");
        // Password < 8 characters & missing uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & missing lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & missing special characters & numbers
        passwordCheck("A#a1@759");
        // Password < 8 characters & missing special characters & uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & missing special characters & lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & missing numbers & uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & missing numbers & lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters & only lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters & only uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters & only numbers
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters & only special characters
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters & missing special characters
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters & missing numbers
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters & missing uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters & missing lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters & missing special characters & numbers
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters & missing special characters & uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters & missing special characters & lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters & missing numbers & uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three same characters & missing numbers & lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & only lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & only uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & only numbers
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & only special characters
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & missing special characters
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & missing numbers
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & missing uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & missing lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & missing special characters & numbers
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & missing special characters & uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & missing special characters & lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & missing numbers & uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & missing numbers & lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & three same characters
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & three same characters & only lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & three same characters & only uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & three same characters & only numbers
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & three same characters & only special characters
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & three same characters & missing special characters
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & three same characters & missing numbers
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & three same characters & missing uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & three same characters & missing lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & three same characters & missing special characters & numbers
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & three same characters & missing special characters & uppercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & three same characters & missing special characters & lowercase
        passwordCheck("A#a1@759");
        // Password < 8 characters & three consecutive characters & three same characters & missing numbers & uppercase
        passwordCheck("A#a1@759");
    }
}