package com.company;

import java.util.ArrayList;

public class SpeedoSort {

    static boolean debug = false;

    public static void main(String[] args) {

        //parameters for random array generation
        int size = 100;
        int mult = 100;

        ArrayList<Integer> numbers = new ArrayList<>();

        //generate random array to sort
        for (int i = 0; i < size; i++) {
            numbers.add((int) (Math.random() * mult));
        }

        System.out.println(numbers.toString());

        numbers = quickSortSubset(numbers,0);

        System.out.println(numbers.toString());

    }
    public static ArrayList<Integer> quickSortSubset(ArrayList<Integer> input, int level){

        //if the input array size == 1 then the input is already sorted
        if(input.size() < 2){
            return input;
        }

        //pivot is the last number in the input array
        //currentPos is the current index being compared to pivot
        int pivot = input.get(input.size()-1);
        int currentPos = 0;
        ArrayList<Integer> auxList = new ArrayList<>();

        /* the loop runs until currentPos reaches the pivot
         * each time the loop runs, input[currentPos] is either kept if less than
         * the pivot, or moved to the auxList if greater than or equal */
        while(currentPos < input.size()-1) {

            if(debug) {
                tabPrint("input: " + input.toString(), level);
                tabPrint("auxList: " + auxList.toString(), level);
                tabPrint("Pivot: " + pivot, level);
            }


            if (input.get(currentPos) >= pivot) { //move number to auxList if it's greater or equal to pivot
                if(debug) tabPrint("Move "+input.get(currentPos)+" to auxList",level);
                auxList.add(input.remove(currentPos));
            } else { //keep number if it's less than pivot
                if(debug) tabPrint("Keep "+input.get(currentPos),level);
                currentPos++;
            }
        }

        //remove pivot from subset to be sorted since it is already in it's correct position
        input.remove(input.size()-1);

        //recursively sorts both sets of numbers
        input = quickSortSubset(input, level+1);
        auxList = quickSortSubset(auxList,level+1);

        //recombines all elements into one array
        input.add(pivot);
        input.addAll(auxList);

        return input;

    }

    public static void tabPrint(String input,int level){
        for(int i = 0; i < level; i++){
            System.out.print("    ");
        }
        System.out.println(input);
    }
}
