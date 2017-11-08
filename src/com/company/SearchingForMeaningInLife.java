package com.company;

import java.util.Arrays;

public class SearchingForMeaningInLife {
    public static void main(String[] args) {

        int num = 7;
        int size = 10;
        int multiplier = 25;

        int[] thing = new int[size];

        for(int i = 0; i < size; i++){
            thing[i] = (int)(Math.random()*multiplier);
        }

        Arrays.sort(thing);

        System.out.println(Arrays.toString(thing));

        System.out.println("the number "+num+" is at index "+ findValue(thing,num));

    }

    public static int findValue(int[] sortedList, int target){
        int pos = -1;
        int s = 0;
        int e = sortedList.length-1;
        int p = sortedList.length/2;

        int i = 0;
        while(true){
            System.out.println("iteration " + i);
            i++;
            System.out.println("s: "+s+" e: "+e+" p: "+p);

            if(target == sortedList[p]) { //if target found
                pos = p;
                break;
            } else if (s == p){ //if target is not found
                break;
             }else if(target < sortedList[p]){ //if target is less than point
                e = p;
                p = (e-s)/2 + s;
            } else if(target > sortedList[p]) { //if target  is greater than point
                s = p;
                p = (e-s) / 2 + s;
            }
        }

        return pos;
    }
}
