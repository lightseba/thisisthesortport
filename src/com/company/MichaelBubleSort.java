package com.company;

import java.util.Arrays;

public class MichaelBubleSort {

    public static long sort() {

        long time = System.currentTimeMillis();
        int size = 1000;
        int mult = 1000;

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * mult);
        }

        //System.out.println(Arrays.toString(numbers));

        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(numbers));
        return System.currentTimeMillis()-time;
    }
}