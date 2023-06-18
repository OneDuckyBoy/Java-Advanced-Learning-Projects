import java.util.*;

public class zad_2_Mouse_And_Cheese_Again {
    public static int row = 0;
    public static int col = 0;
    public static int cheesesEaten = 0;
    public static boolean isInTheGrid = true;


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

        String command = scanner.nextLine();
        while (!command.equals("end")&& isInTheGrid){

            if (command.equals("up")){
                moveMouse(grid,-1,0);
            } else if (command.equals("down")) {
                moveMouse(grid,1,0);

            }else if (command.equals("left")){
                moveMouse(grid,0,-1);

            }else if (command.equals("right")){
                moveMouse(grid,0,+1);

            }
            if (!isInTheGrid){
                break;
            }

            command = scanner.nextLine();
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

    private static void moveMouse(char[][] grid,int rowMutator, int colMutator) {


        int nextRow = row+rowMutator;
        int nextCol = col+colMutator;
        boolean isBonusHit = false;
        if (isOutOfBounds(grid,nextRow,nextCol)){
            isInTheGrid = false;
            grid[row][col] = '-';
            return;
        }
        if (grid[nextRow][nextRow]=='c'){
            cheesesEaten++;

        }else if (grid[nextRow][nextRow]=='B'){

            isBonusHit = true;
        }
        grid[row][col] = '-';
        grid[nextRow][nextCol] = 'M';
        row = nextRow;
        col = nextCol;
        if (isBonusHit){
            moveMouse(grid,rowMutator,colMutator);
        }
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
