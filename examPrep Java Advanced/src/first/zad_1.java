package first;

import java.util.*;
import java.util.stream.Collectors;

public class zad_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //stack -> push pop peek FIFO
        // 1 2 3 4 5 -> 5 4 3 2 1

        //queue -> offer poll peek LIFO
        // 1 2 3 4 5 -> 1 2 3 4 5

        //tr mi
        //1

        //5
        String input = scanner.nextLine();
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .forEach(liquids::offer);

        input = scanner.nextLine();

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .forEach(ingredients::push);
//        System.out.println("<======================>");
//        System.out.println(liquids.peek());
//        System.out.println(ingredients.peek());


        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie= 0;
        while (!liquids.isEmpty() && !ingredients.isEmpty()){
            int firstLiquid = liquids.pop();
            int firstIngredient = ingredients.poll();
            int sum = firstIngredient+firstLiquid;
            if (sum==25){
                bread++;
//                System.out.println("Bread");
            }else if (sum==50){
                cake++;
//                System.out.println("Cake");
            }else if (sum==75){
                pastry++;
//                System.out.println("Pastry");
            }else if (sum==100){
                fruitPie++;
//                System.out.println("Fruit Pie");
            }else {
                firstIngredient+=3;
                ingredients.offerFirst(firstIngredient);
            }
        }
        if (bread!=0&&cake!=0&&pastry!=0&&fruitPie!=0){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (liquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else {

            System.out.println("Liquids left: "+printIngredients(liquids,", "));

        }
        if (ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        }else {

            System.out.println("Ingredients left: "+printIngredients(ingredients,", "));

        }
        System.out.printf("Bread: %d%n",bread);
        System.out.printf("Cake: %d%n",cake);
        System.out.printf("Fruit Pie: %d%n",fruitPie);
        System.out.printf("Pastry: %d%n",pastry);




    }

    private static String printIngredients(ArrayDeque<Integer> ingredients, String regex) {
        return ingredients.stream()
                .map(String::valueOf).collect(Collectors.joining(regex));
    }
}
