package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    static boolean debug = false;

    public static void main(String[] args){

        //parameters for random array generation
        int size = 10;
        int mult = 10;

        ArrayList<Integer> numbers = new ArrayList<>();

        //generate random array to sort
        for (int i = 0; i < size; i++) {
            numbers.add((int) (Math.random() * mult));
        }

        System.out.println(numbers.toString());

        int start = 0;
        int end = numbers.size()-1;

        //start recursive method with full array
        numbers = splitList(numbers, start, end, 0);

        System.out.println(numbers.toString());
    }



    public static ArrayList<Integer> splitList(ArrayList<Integer> arr, int start, int end, int level){
        /* recursively splits array until it gets to size 1, then call method mergeSort
         * to combine the array subsets until the full array is sorted */

        if(debug) {
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            System.out.println("Split Start: " + start + " End: " + end);
        }

        ArrayList<Integer> output = new ArrayList<>();

        //if the array subset contains only one value, make it the sole value of the output array and return
        if(start ==  end){
            output.add(arr.get(start));

            if(debug) {
                for (int i = 0; i < level; i++) {
                    System.out.print("  ");
                }
                System.out.println(output.toString());
            }

            return output;
        }

        /* since the array size >= 2, it can be split into two halves, both of which recursively
        * split until they get to size 1*/
        int middle = ((end-start)/2)+start;
        ArrayList<Integer> leftList = splitList(arr, start, middle,level+1);
        ArrayList<Integer> rightList = splitList(arr, middle+1, end,level+1);

        if(debug) {
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }

            System.out.println("Combine (" + start + "," + middle + ") and (" + (middle + 1) + "," + end + ")");

            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
        }

        /* at the lowest level, the left and right arrays are both size 1, and the mergeSort method combines them
         * into one sorted array
         *
         * this combined array is returned and becomes a higher level left or right array, which is then combined
         * with another sorted array subset, until the whole array is sorted*/

        return mergeSort(leftList, rightList);

    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> left, ArrayList<Integer> right){

        if(debug) System.out.println(left.toString()+" and "+right.toString());

        ArrayList<Integer> comboList = new ArrayList<>();


        while(!left.isEmpty() || !right.isEmpty()){

            if(left.isEmpty() || (!right.isEmpty() && (right.get(0) < left.get(0)))){
                if(debug) System.out.println("Pull "+right.get(0)+ " from right");
                comboList.add(right.remove(0));
            } else{
                if(debug) System.out.println("Pull "+left.get(0)+ " from left");
                comboList.add(left.remove(0));
            }

        }

        if(debug) System.out.println(comboList.toString());
        return comboList;

    }

}
