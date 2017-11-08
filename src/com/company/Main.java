package com.company;

public class Main {

    public static void main(String[] args) {


        int trials = 10;
        long insertionSort = 0;
        long selectionSort = 0;
        long bubbleSort = 0;


        for(int i = 0; i < trials; i++){
            //insertionSort += InsertSort.sort();
            selectionSort += Selectamundo.sort();
            //bubbleSort += MichaelBubleSort.sort();
        }

        System.out.print("Insertion: ");
        System.out.println(insertionSort);
        System.out.print("Selection: ");
        System.out.println(selectionSort);
        System.out.print("Bubble: ");
        System.out.println(bubbleSort);

    }
}
