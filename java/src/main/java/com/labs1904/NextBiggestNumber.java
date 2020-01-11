package com.labs1904;

import java.util.Arrays;

public class NextBiggestNumber {

    public static void main(String[] args) {
        Integer input = Integer.parseInt(args[0]);
        Integer nextBiggestNumber = getNextBiggestNumber(input);
        System.out.println("Input: " + input);
        System.out.println("Next biggest number: " + nextBiggestNumber);
    }

    public static int getNextBiggestNumber(Integer i) {
        
        int n;
        char []charArray = toCharArray(i);
        int len = charArray.length;

        for( n = len - 1; n > 0; n--) {
            if (charArray[n] > charArray[n -1]) {
                break;
            }
        }

        if (n == 0) {
            return -1;
        } 

        int x = charArray[n-1], min = n;

        for(int j = n + 1; j < len; j++) {
            if (charArray[j] > x && charArray[j] < charArray[min]) {
                min = j;
            }
        }

        swap(charArray, n - 1, min);
        Arrays.sort(charArray, n, len);

        return Integer.parseInt(new String(charArray));
    }


    public static char[] toCharArray(Integer i) {

        String temp = Integer.toString(i);
        char[] charArray = new char[temp.length()];

        for (int c = 0; c < temp.length(); c++) {
            charArray[c] = temp.charAt(c);
        }

        return charArray;
    }

    public static void swap(char ar[], int i, int j) {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }


    
}
