import java.util.*;

public class zad_1_Bouquets {
    public static void main(String[] args) {
        //stack -> push pop peek FIFO
        // 1 2 3 4 5 -> 5 4 3 2 1

        //queue -> offer poll peek LIFO
        // 1 2 3 4 5 -> 1 2 3 4 5

        //tr mi
        //1

        //5

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .forEach(tulips::push);

        input = scanner.nextLine();

        ArrayDeque<Integer> daffodils = new ArrayDeque<>();

        Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .forEach(daffodils::offer);

//        System.out.println(tulips.poll());
//        System.out.println(daffodils.pop());

        int bouquets = 0;
        int storedFlowers = 0;
        while (!tulips.isEmpty()&&!daffodils.isEmpty()){
            int flower1 = tulips.poll();
            int flower2 = daffodils.pop();
            int sum = flower1+flower2;
            if (sum==15){
                bouquets++;
            } else if (sum>15) {
                while (sum>15){
                    sum-=2;
                    if (sum==15){
                        bouquets++;
                        break;
                    }else if(sum<15){
                        storedFlowers+=sum;
                        break;
                    }
                }

            }else if(sum<15){
                storedFlowers+=sum;
            }

        }
        //System.out.println(storedFlowers);

        bouquets+=storedFlowers/15;
        //System.out.println(bouquets);

        if (bouquets>=5){
            System.out.printf("You made it! You go to the competition with %d bouquets!%n",bouquets);
        }else {
            System.out.printf("You failed... You need more %d bouquets.%n",5-bouquets);
        }
    }
}
