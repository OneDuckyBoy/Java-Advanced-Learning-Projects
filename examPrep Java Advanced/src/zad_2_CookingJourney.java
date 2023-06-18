import java.util.*;

public class zad_2_CookingJourney {

    public static int Row = 0;
    public static int Col = 0;
    public static int size = 0;

    public static int money = 0;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = Integer.parseInt(scanner.nextLine());
        char[][] shop = new char[size][size];



        for (int i = 0; i < size; i++) {
            String currRow = scanner.nextLine();
            shop[i] = currRow.toCharArray();
            if (currRow.contains("S")) {
                Row = i;
                Col = currRow.indexOf("S");
            }
        }


        boolean isInShop = true;
        while (money<50 && isInShop) {
            String input = scanner.nextLine();
            if (input.equals("up")) {
                isInShop = move(shop,-1,0);
            } else if (input.equals("down")) {
                isInShop = move(shop,1,0);

            } else if (input.equals("left")) {
                isInShop = move(shop,0,-1);
            } else if (input.equals("right")) {
                isInShop = move(shop,0,1);
            }
            //printMatrix(shop);
        }

        if (!isInShop){
            System.out.println("Bad news! You are out of the pastry shop.");

        }else {
            System.out.println("Good news! You succeeded in collecting enough money!");

        }
        System.out.printf("Money: %d%n",money);
        printMatrix(shop);
    }
    public static boolean move(char[][] shop, int rowMutator, int colMutator){
        int nextRow = Row + rowMutator;
        int nextCol = Col + colMutator;
        shop[Row][Col] = '-';
        if (isOutOfBounds(shop,nextRow,nextCol)){
            return false;
        }

        shop[Row][Col] = '-';
        char symbol =  shop[nextRow][nextCol];
        if (Character.isDigit(symbol)){
            money+= symbol-'0';
        }
        else if (symbol=='P') {
            shop[nextRow][nextCol] = '-';

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (shop[i][j] == 'P') {
                        nextRow = i;
                        nextCol = j;
                        break;
                    }
                }
                if (shop[nextRow][nextCol] == 'P') {
                    break;
                }
            }
        }

        shop[nextRow][nextCol] = 'S';

        Row = nextRow;
        Col = nextCol;
        return true;
    }


    public static void printMatrix(char[][]matrix){
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r<0||r>= matrix.length||c<0||c>= matrix[r].length;
    }
}
