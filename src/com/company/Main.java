package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /**
     * Declaration of Variables and creation of Array
     *
     * @param args
     */
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner eingabe = new Scanner(System.in);
        System.out.println("Gib die Größe vom Array an: ");
        int index = eingabe.nextInt();

        int[] arr = new int[index];
        int size = arr.length;

        fillArr(arr, rand);
        printarr(arr);
        heapify(arr, size);
        printarr(arr);
    }

    /**
     * Function that prints an Array
     * @param arr
     */
    private static void printarr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Fills the Array with random numbers from 1 to 10
     * @param arr
     * @param rand
     */
    private static void fillArr(int[] arr, Random rand) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10) + 1;
        }
    }

    /**
     * Creates a Heap from the Array and sorts it
     * @param arr
     * @param size
     */
    private static void heapify(int[] arr, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            sink(arr, size, i);
        }
        printarr(arr);
        for (int i = size - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            sink(arr, i, 0);
        }
    }

    /**
     * Swaps to Elements in the Array
     * @param arr
     * @param largest
     * @param i
     */
    private static void swap(int[] arr, int largest, int i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }

    /**
     * Compares Parent and Children Elements so that the biggest Element is always the first
     * @param arr
     * @param size
     * @param i
     */
    private static void sink(int[] arr, int size, int i) {
        int biggest = i, left = getLeft(i), right = getRight(i);

        if (left < size && arr[left] > arr[biggest]) {
            biggest = left;
        }
        if (right < size && arr[right] > arr[biggest]) {
            biggest = right;
        }
        if (biggest != i) {
            swap(arr, biggest, i);
            sink(arr, size, biggest);
        }
    }

    /**
     * Equation to get the right Child
     * @param indv
     * @return
     */
    private static int getRight(int indv) {
        return indv * 2 + 2;
    }

    /**
     * Equation to get the left Child
     * @param indv
     * @return
     */
    private static int getLeft(int indv) {
        return indv * 2 + 1;
    }
}