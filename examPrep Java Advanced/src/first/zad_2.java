package first;

import java.util.*;

public class zad_2 {

    public static boolean hasWon = true;
    public static int Row = 0;
    public static int Col = 0;
    public static int money = 0;
    public static int size = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = Integer.parseInt(scanner.nextLine());
        char [][] bakery = new char[size][size];

        boolean isInTheBakery = true;



        for (int i = 0; i < size; i++) {
            String currRow = scanner.nextLine();
            bakery[i] = currRow.toCharArray();
            if (currRow.contains("S")){
                Row = i;
                Col = currRow.indexOf("S");
            }if (currRow.contains("S")){
                Row = i;
                Col = currRow.indexOf("S");
            }




        }
        while (money<=50&& isInTheBakery){
            String input = scanner.nextLine();

            int currRow = Row;
            int currCol = Col;

            //bakery[row][col] = '-';
            if(input.equals("up")){


            } else if(input.equals("down")){

            }else if(input.equals("left")){

            }else if(input.equals("right")){

            }
        }

//        System.out.println(row);
//        System.out.println(col);
//        printMatrix(bakery);
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
    private static void movePlayer(char[][] matrix,int rowMutator,int colMutator) {

        int nextRow = Row+rowMutator;
        int nextCol = Col+colMutator;
        if (isOutOfBounds(matrix,nextRow, nextCol)) {
            //game over
            hasWon = false;

        }
        if (matrix[nextRow][nextCol]=='O'){
            matrix[nextRow][nextCol]='-';

            for (int i = 0; i < size; i++) {

                String currRow = matrix[i].toString();

                    nextRow = i;
                    nextCol = currRow.indexOf("O");



            }
        }else if (matrix[nextRow][nextCol]=='B'){
            matrix[Row][Col]='-';
            Row = nextRow;
            Col = nextCol;
            movePlayer(matrix,rowMutator,colMutator);
            return;
        }else if (isNum(matrix,nextRow,nextCol)){
            money +=Integer.parseInt(String.valueOf(matrix[nextRow][nextCol]));
        }

        /*else if (matrix[nextRow][nextCol]=='F'){
             hasWon = true;
        }*/

        if (matrix[Row][Col]!='S'){
            matrix[Row][Col]='-';
        }

        matrix[nextRow][nextCol] = 'S';
        Row = nextRow;
        Col = nextCol;

    }
    public static boolean isNum(char[][] matrix,int row,int col){
        char currCh = matrix[row][col];
        if (String.valueOf(currCh).equals("1")){

        }
        switch (String.valueOf(currCh)){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                return true;
        }
        return false;
    }
}
