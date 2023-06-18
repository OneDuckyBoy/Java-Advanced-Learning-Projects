import java.util.*;

public class zad_1 {
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
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .forEach(ingredients::offer);

        input = scanner.nextLine();

        ArrayDeque<Integer> freshnessLevel = new ArrayDeque<>();

        Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .forEach(freshnessLevel::push);

        

        int pear = 0;
        int Harvest = 0;
        int Apple = 0;
        int Fashion= 0;
        while (!ingredients.isEmpty() && !freshnessLevel.isEmpty()){

            if (ingredients.peek()==0){
                ingredients.pop();
                continue;
            }
            int ingredient = ingredients.pop();
            int level = freshnessLevel.poll();
            int result = ingredient*level;
            if (result==150){
                pear++;
            } else if (result==250) {
                Harvest++;
            } else if (result==300) {
                Apple++;
            } else if (result==400) {
                Fashion++;
            }else {
                ingredient+=5;
                ingredients.offer(ingredient);
//                System.out.println("test");
            }
        }
        if (pear !=0&& Harvest!=0&& Apple!=0&&Fashion!=0) {
            System.out.println("It's party time! The cocktails are ready!");

        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()){
            int ingredientsLeft = 0;
            for (Integer ingredient : ingredients) {
                ingredientsLeft+=ingredient;
            }
            System.out.printf("Ingredients left: %d%n",ingredientsLeft);

        }
        if (Apple !=0){
            System.out.printf(" # %s --> %d%n","Apple Hinny",Apple);
        }
        if (Fashion !=0){
            System.out.printf(" # %s --> %d%n","High Fashion",Fashion);
        }
        if (pear !=0){
            System.out.printf(" # %s --> %d%n","Pear Sour",pear);
        }
        if (Harvest !=0){
            System.out.printf(" # %s --> %d%n","The Harvest",Harvest);
        }





    }
}
