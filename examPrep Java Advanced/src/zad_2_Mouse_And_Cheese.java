import java.util.*;

public class zad_2_Mouse_And_Cheese {

    public static int row = 0;
    public static int col = 0;
    public static int cheesesEaten = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int size = Integer.parseInt(scanner.nextLine());
        char[][] grid = new char[size][size];
        for (int i = 0; i < size; i++) {
            String currRow = scanner.nextLine();
            grid[i] = currRow.toCharArray();
            if (currRow.contains("M")){
                row = i;
                col = currRow.indexOf("M");
            }
        }

        boolean isInTheGrid = true;

        while (cheesesEaten<5&&isInTheGrid){
            String input = scanner.nextLine();
            if (input.equals("up")){
                isInTheGrid = move(grid,-1,0);
            } else if (input.equals("down")){
                isInTheGrid = move(grid,1,0);

            } else if (input.equals("left")){
                isInTheGrid = move(grid,0,-1);

            } else if (input.equals("right")){
                isInTheGrid = move(grid,0,1);

            }else if (input.equals("end")){
                break;
            }
//            printMatrix(grid);
        }

        if (!isInTheGrid){
            System.out.println("Where is the mouse?");
        }
        if (cheesesEaten<5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",5-cheesesEaten);
        }else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n",cheesesEaten);
        }
        printMatrix(grid);


    }
    public static boolean move(char[][] grid, int rowMutator, int colMutator){

        int nextRow = row+rowMutator;
        int nextCol = col+colMutator;
        if (isOutOfBounds(grid,nextRow,nextCol)) {
            grid[row][col] = '-';
            return false;
        }
        char symbol = grid[nextRow][nextCol];
        if (symbol=='c'){
            cheesesEaten++;
        }
        else if (symbol=='B') {
            grid[row][col] = '-';
            grid[nextRow][nextCol] ='M';
            row = nextRow;
            col = nextCol;
            nextRow+=rowMutator;
            nextCol+=colMutator;
            grid[row][col] = '-';

            symbol = grid[nextRow][nextCol];
            if (symbol=='c'){
                cheesesEaten++;
            }

            grid[nextRow][nextCol] ='M';
            row = nextRow;
            col = nextCol;
            nextRow+=rowMutator;
            nextCol+=colMutator;
            symbol = grid[nextRow][nextCol];
            if (symbol=='c'){
                cheesesEaten++;
            }
        }

        grid[row][col] = '-';
        grid[nextRow][nextCol] ='M';
        row = nextRow;
        col = nextCol;
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