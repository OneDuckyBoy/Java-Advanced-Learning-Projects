

import java.util.*;
import java.util.stream.Collectors;

public class zad_2_Racing_Cars {

    public static int size = 0;
    public static int row = 0;
    public static int col = 0;
    public static int totalDistance = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        size = Integer.parseInt(scanner.nextLine());

        String name = scanner.nextLine();

        char[][] field = new char[size][size];

        for (int i = 0; i < size; i++) {


            //kato ima space
            List<Character> characterList = Arrays.stream(scanner.nextLine().split(" "))
                    .map(e -> e.charAt(0))
                    .collect(Collectors.toList());

            for (int j = 0; j < characterList.size(); j++) {
                char currChar = characterList.get(j);


                field[i][j] = currChar;
            }

        }
        String direction = scanner.nextLine();
        boolean reachedF = false;
        while (!direction.equals("End")&&!reachedF){


            if (direction.equals("up")) {
                reachedF = move(field,-1,0);
            } else if (direction.equals("down")) {
                reachedF = move(field,1,0);
            } else if (direction.equals("left")) {
                reachedF = move(field,0,-1);
            } else if (direction.equals("right")) {
                reachedF = move(field,0,1);
            }
            direction = scanner.nextLine();
        }



        if (reachedF){
            System.out.printf("Racing car %s finished the stage!%n",name);
        }else {
            System.out.printf("Racing car %s DNF.%n",name);
        }
        System.out.printf("Distance covered %d km.%n",totalDistance);
        printMatrix(field);
    }

    private static boolean move(char[][] field, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;
        char symbol = field[nextRow][nextCol];
        field[row][col] = '.';

        if (symbol=='.'){
            totalDistance+=10;
        }
        if (symbol == 'T') {
            totalDistance+=30;
            field[nextRow][nextCol] = '.';

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (field[i][j] == 'T') {
                        nextRow = i;
                        nextCol = j;
                        break;
                    }
                }
                if (field[nextRow][nextCol] == 'T') {
                    break;
                }
            }
        }else if (symbol=='F'){
            totalDistance+=10;
            field[nextRow][nextCol] = 'C';
            return true;
        }


            field[nextRow][nextCol] = 'C';
            row = nextRow;
            col = nextCol;
            return false;
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
