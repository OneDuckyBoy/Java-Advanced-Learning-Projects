package org.example;

import java.util.*;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraysCount = scanner.nextInt();
        int sizeOfArray = scanner.nextInt();
        int [][] first =new  int[arraysCount][sizeOfArray];
        for (int i = 0; i < arraysCount; i++) {
            int[] arr =first[i];
            for (int j = 0; j < sizeOfArray; j++) {
                first[i][j] = scanner.nextInt();
            }
            first[i] = arr;
        }

        arraysCount = scanner.nextInt();
        sizeOfArray = scanner.nextInt();

        int[][] second = new int[arraysCount][sizeOfArray];
        for (int r = 0; r < second.length; r++) {
            for (int c = 0; c < second[r].length; c++) {
                second[r][c]=scanner.nextInt();
            }

        }
        if (Arrays.deepEquals(first,second)){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }
    public static void printMatrix (int[][] matrix){
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]+" ");
            }
            System.out.println();
        }
    }
}