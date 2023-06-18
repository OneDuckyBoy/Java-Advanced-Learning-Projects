package first;

import java.util.*;

public class zad_2_again {
    public static int Row = 0;
    public static int Col = 0;
    public static int size = 0;
    public static int money = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = Integer.parseInt(scanner.nextLine());
        char[][] bakery = new char[size][size];



        for (int i = 0; i < size; i++) {
            String currRow = scanner.nextLine();
            bakery[i] = currRow.toCharArray();
            if (currRow.contains("S")) {
                Row = i;
                Col = currRow.indexOf("S");
            }



        }
        boolean isInBakery = true;
        while (money < 50 && isInBakery) {
            String input = scanner.nextLine();

            int currRow = Row;
            int currCol = Col;

            //move(Row,Col,bakery);

            //bakery[row][col] = '-';
            if (input.equals("up")) {
                isInBakery = move(bakery,-1,0);
            } else if (input.equals("down")) {
                 isInBakery = move(bakery,1,0);

            } else if (input.equals("left")) {
                 isInBakery = move(bakery,0,-1);

            } else if (input.equals("right")) {
                 isInBakery = move(bakery,0,1);

            }
        }
        if (isInBakery){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: "+money);
        printMatrix(bakery);
        //System.out.println("end");
    }

    private static boolean move(char[][] bakery, int rowMutator, int colMutator) {
        int currRow = Row + rowMutator;
        int currCol = Col + colMutator;

        bakery[Row][Col] = '-';
        if (isOutOfBounds(bakery, currRow,currCol)){
            System.out.println("Bad news, you are out of the bakery.");
            return false;

        }
        char symbol =  bakery[currRow][currCol];
        if (Character.isDigit(symbol)){
            money+= symbol-'0';
        }
        else if (symbol=='O'){
            bakery[currRow][currCol] = '-';

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (bakery[i][j]=='O'){
                        currRow = i;
                        currCol = j;
                        break;
                    }
                }
                if (bakery[currRow][currCol]=='0' ){
                    break;
                }
            }
        }
        bakery[currRow][currCol] = 'S';

//        if (bakery[currRow][currCol] == 'O') {
//
//            for (int i = 0; i < size; i++) {
//                String curRow = bakery[i].toString();
//                bakery[i] = curRow.toCharArray();
//                if (curRow.contains("O")) {
//                    Row = i;
//                    Col = curRow.indexOf("O");
//                }
//
//            }
//
//        }
        Row = currRow;
        Col = currCol;
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