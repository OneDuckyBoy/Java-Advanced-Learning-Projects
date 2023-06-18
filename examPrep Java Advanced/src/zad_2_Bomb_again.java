import java.util.*;
import java.util.stream.Collectors;

public class zad_2_Bomb_again {
    public static int row = 0;
    public static int col = 0;
    public static int bombs = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(",");

        char[][] field = new char[size][size];

        for (int i = 0; i < size; i++) {


            //kato ima space
            List<Character>characterList = Arrays.stream(scanner.nextLine().split(" "))
                    .map(e->e.charAt(0))
                    .collect(Collectors.toList());

            for (int j = 0; j < characterList.size(); j++) {
                char currChar = characterList.get(j);
                if (currChar=='s'){
                    row = i;
                    col = j;
                }
                if (currChar=='B'){
                    bombs++;
                }
                field[i][j] = currChar;
            }

        }


        int bombsFound = 0;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            switch (command){
                case "up":
                    if (row!=0){
                        row--;
                    }
                    break;
                case "down":
                    if (row!= size-1){
                        row++;
                    }
                    break;
                case "right":
                    if (col!=size-1){
                        col++;
                    }
                    break;
                case "left":
                    if (col!=0){
                        col--;
                    }
                    break;
            }

            if (field[row][col]=='B'){
                field[row][col] = '+';
                System.out.println("You found a bomb!");
                bombsFound++;
                if (bombsFound==bombs){
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            }else if (field[row][col]=='e'){
                System.out.printf("END! %d bombs left on the field%n",bombs-bombsFound);
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n",bombs-bombsFound,row,col);

        //printMatrix(field);
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
