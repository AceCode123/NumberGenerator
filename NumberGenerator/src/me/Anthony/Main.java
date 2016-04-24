package me.Anthony;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static HashMap<Integer, Integer> matches = new HashMap<Integer, Integer>();
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("How many random numbers would you like printed out? (Lowest 1)");
        int amount = s.nextInt();
        generate(amount);
    }

    public static void generate(int amount) {
        if (amount > 0) {
            int[] numbers = new int[amount];
            for (int i = 0; i < amount; i++) {
                Random r = new Random();
                int random = r.nextInt(amount);
                numbers[i] = random;
                System.out.println(random);
            }
            for(int i = 0; i < numbers.length; i++) {
                if(matches.containsKey(numbers[i]) == false) {
                    matches.put(numbers[i], 1);
                } else {
                    matches.put(numbers[i], matches.get(numbers[i])+1);
                }
            }
            int topNum = 0;
            int topPrints = 0;
            for(int i = 0; i < matches.size(); i++) {
                if(matches.containsKey(i)) {
                    if (matches.get(i) > topPrints) {
                        topNum = i;
                        topPrints = matches.get(i);
                    }
                }
            }

            System.out.println("Finished successfully printed out " + amount + " numbers!");
            System.out.println("The number printed out the most was " + topNum + " with a total of " + topPrints + " prints!");

        } else {
            System.out.println("Please enter a number greater than 1!");
            int amount2 = s.nextInt();
            generate(amount2);
        }
    }

}
