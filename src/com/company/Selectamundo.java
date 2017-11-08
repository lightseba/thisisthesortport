package com.company;

import java.util.Arrays;

public class Selectamundo {

    public static long sort() {

        long time = System.currentTimeMillis();
        int size = 10;
        int mult = 10;

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * mult);
        }

        System.out.println(Arrays.toString(numbers));

        for(int i = 0; i < size; i++){
            int pos = i;
            for(int j = i+1; j < size; j++){
                if(numbers[j] < numbers[pos]){
                    pos = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[pos];
            numbers[pos] = temp;

            //System.out.println(Arrays.toString(numbers));
        }

        System.out.println(Arrays.toString(numbers));

        return System.currentTimeMillis()-time;
    }
}