package org.example;

import java.util.*;

public class zad_1_Energy_Drinks {
    public static void main(String[] args) {
        //stack -> push pop peek FIFO
        // 1 2 3 4 5 -> 5 4 3 2 1

        //queue -> offer poll peek LIFO
        // 1 2 3 4 5 -> 1 2 3 4 5

        //tr mi
        //1

        //5

        //x
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> caffeine = new ArrayDeque<>();
        Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .forEach(caffeine::push);

        input = scanner.nextLine();

        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();

        Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .forEach(energyDrinks::offer);

//        System.out.println(caffeine.poll());
//        System.out.println(energyDrinks.pop());

        int milligramsSum = 0;
        while (!energyDrinks.isEmpty()&&!caffeine.isEmpty()){
            int currCaffeineAmount = caffeine.poll();
            int currEnergyDrink = energyDrinks.pop();
            int currSum = currCaffeineAmount*currEnergyDrink;
            if (milligramsSum+currSum<=300){
                milligramsSum+=currSum;
            }else {
                energyDrinks.offer(currEnergyDrink);
                if (milligramsSum-30<=0){
                    milligramsSum =0;
                }else {
                    milligramsSum-=30;
                }
            }
        }
        if (energyDrinks.isEmpty()){
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }else {
            StringBuilder sb =new StringBuilder("Drinks left: ");
            for (Integer energyDrink : energyDrinks) {
                sb.append(energyDrink).append(", ");
            }
            sb.lastIndexOf(", ");

            sb.delete(sb.lastIndexOf(", "),sb.toString().length());
            System.out.println(sb);
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n",milligramsSum);
    }
}
