package ru.sfedu.islabs.lab3;

import java.util.Arrays;
import java.util.Scanner;

public class Hash {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println(hash_algo(scanner.nextLine().toCharArray()));
    }

    public static long hash_algo(char[] str) {
        long result = 0;
        int prime = 2;
        for(char x: str) {
            result += (int)x + prime;
            do {
                prime++;
            } while (!isPrime(prime));
        }
        return result;
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
