package com.company;

import java.util.Arrays;

public class InsertSort {
    public static long sort() {

        long time = System.currentTimeMillis();
        int size = 1000;
        int multiplier = 1000;

        int[] a = new int[size];

        for(int i = 0; i < size; i++){
            a[i] = (int)(Math.random()*multiplier);
        }

        System.out.println(Arrays.toString(a));

        for(int i = 0; i < size; i++){ //i is the index to be sorted
            for(int j = i-1; j >= 0; j--){//j moves in front of i to see where to place i
                if(a[j] <= a[i]){ //if i fits into the list at this point, place it here and move everything else down
                    int temp = a[i];

                    for(int k = i; k > j+1; k--){
                        a[k] = a[k-1];
                    }

                    a[j+1] = temp;
                    //System.out.println("less");
                    break;
                } else if (j == 0){ //if i is the smallest number in the current sorted array, place it at the front and bump everything down
                    int temp = a[i];

                    for(int k = i; k > 0; k--){
                        a[k] = a[k-1];
                    }

                    a[0] = temp;
                    //System.out.println("end");
                }
            }
            System.out.println(Arrays.toString(a));
        }
        System.out.println(Arrays.toString(a));

        return System.currentTimeMillis()-time;
    }
}
