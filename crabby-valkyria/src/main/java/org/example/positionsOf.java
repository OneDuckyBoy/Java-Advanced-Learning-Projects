package org.example;

import java.util.*;

public class positionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix =new int[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int numToFind = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int currNum = matrix[r][c];
                if (currNum==numToFind){
                    isFound=true;
                    System.out.println(r+ " "+ c);
                }
            }
        }
        if (!isFound){
            System.out.println("not found");
        }
    }
}
