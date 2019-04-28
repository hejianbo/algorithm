package me.jianbo.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortingUtils {
    public static int[] genRandomNumbers(int num) {
        int[] numbers = genNumbers(num);

        return numbers;
    }

    private static int[] genNumbers(int num) {
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }

    private static void shuffle(int[] numbers, int times) {
        Random random = new Random();
        for (int i = 1; i < times; i++) {
            int m = random.nextInt(numbers.length);
            int n = random.nextInt(numbers.length);
            int temp = numbers[m];
            numbers[m] = numbers[n];
            numbers[n] = temp;
        }
    }

    public static boolean isOrderByAsc(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return true;
        }

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void print(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }
        for (int number : numbers) {
            System.out.print(number + "\t");
        }
    }

    public static void main(String[] args) {
        int[] numbers = genRandomNumbers(1000);
        shuffle(numbers, 1000);
        print(numbers);
    }
}
