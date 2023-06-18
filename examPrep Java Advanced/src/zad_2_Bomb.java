import java.util.*;

public class zad_2_Bomb {
    public static int row = 0;
    public static int col = 0;
    public static int bombs = 0;
    public static boolean reachedEnd = false;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");

        char[][] field = new char[size][size];

        for (int i = 0; i < size; i++) {

            String currRow = scanner.nextLine();

            field[i] = currRow.toCharArray();

            if (currRow.contains("s")){

                row = i;

                col = currRow.indexOf("s");
            }
            char[] currRowArr = currRow.toCharArray();

            for (int j = 0; j < currRowArr.length; j++) {

                if (currRowArr[j]=='B'){

                    bombs++;

                }
            }
        }
        //System.out.println(row);
        //System.out.println(col);
        int index = 0;
        while (bombs>0){
            if (reachedEnd){
                break;
            }
//            if (index==commands.length){
//                break;
//            }
            String command = commands[index];

            if (command.equals("up")){
                reachedEnd = move(field,-1,0);
            } else if (command.equals("down")){
                reachedEnd = move(field,1,0);

            } else if (command.equals("left")){
                reachedEnd = move(field,0,-2);

            } else if (command.equals("right")){
                reachedEnd = move(field,0,2);

            }
            System.out.println("<=============>");
            printMatrix(field);
            System.out.println("<=============>");
//            System.out.println(command);
            index++;
        }
        if (bombs==0){
            System.out.println("Congratulations! You found all bombs!");
        }else {
            System.out.printf("END! %d bombs left on the field%n",bombs);
        }

    }

    public static boolean move(char[][] field, int rowMutator, int colMutator){

        int nextRow = row+rowMutator;
        int nextCol = col+colMutator;
        if (isOutOfBounds(field,nextRow,nextCol)) {
            return true;
        }
        char symbol = field[nextRow][nextCol];
        if (symbol=='B'){
            bombs--;
            field[nextRow][nextCol] = '+';
            System.out.println("You found a bomb!");
        }
        else if (symbol=='e'){
            System.out.println("e");
            return true;
        }
        field[row][col] = '+';
        field[nextRow][nextCol] ='s';
        row = nextRow;
        col = nextCol;
//        printMatrix(field);
        return false;
    }
    
    public static boolean move1(char[][] field,String position){
        int rowMutator = 0;
        int colMutator = 0;
        if (position.equals("right")){
            colMutator+=1;
        } else if (position.equals("left")) {
            colMutator-=1;
        }else if (position.equals("up")){
            rowMutator-=1;
        } else if (position.equals("down")) {
            rowMutator+=1;
            //System.out.println("down");
        }

        int nextRow = row+rowMutator;
        int nextCol = col+colMutator;
        if (isOutOfBounds(field,nextRow,nextCol)){
            return false;
        }
        char symbol = field[nextRow][nextCol];
        if (symbol=='B'){
            bombs--;
            field[nextRow][nextCol] = '+';
            System.out.println("You found a bomb!");
        }
        else if (symbol=='e'){
            return true;
        }
        row = nextRow;
        col = nextCol;

        System.out.println();
        printMatrix(field);
        System.out.println();
        return false;
    }
    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r<0||r>= matrix.length||c<0||c>= matrix[r].length;
    }
    public static void printMatrix(char[][]matrix){
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
