import java.util.*;

public class zad_1_Energy_Drinks_Again {
    public static void main(String[] args) {
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

        int totalCaffeine = 0;

        while (!energyDrinks.isEmpty()&&!caffeine.isEmpty()){
            int currCaffeineAmount = caffeine.poll();
            int currEnergyDrink = energyDrinks.pop();
            int currSum = currCaffeineAmount*currEnergyDrink;
            if (totalCaffeine+currSum>=300){
                totalCaffeine-=30;
                if (totalCaffeine<0){
                    totalCaffeine=0;
                }
                energyDrinks.offer(currEnergyDrink);
            }else {
                    totalCaffeine+=currSum;

            }

        }
        if (energyDrinks.isEmpty()){
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }else if (energyDrinks.size()==1){
            System.out.println("Drinks left: "+energyDrinks.pop());
        }else {
            StringBuilder sb = new StringBuilder("Drinks left: "+energyDrinks.pop());
            for (Integer energyDrink : energyDrinks) {
                sb.append(", ").append(energyDrink);
            }
            System.out.println(sb.toString());
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n",totalCaffeine);
    }
}
