public class Main {
    public static void main(String[] args) {
        char one  ='1';
        int num = Integer.parseInt(String.valueOf(one));




















    }
    public static boolean hasWon = true;

    public static int Row = 0;
    public static int Col = 0;
    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r<0||r>= matrix.length||c<0||c>= matrix[r].length;
    }
    private static void movePlayer(char[][] matrix,int rowMutator,int colMutator) {

        int nextRow = Row+rowMutator;
        int nextCol = Col+colMutator;
        if (isOutOfBounds(matrix,nextRow, nextCol)) {
            if (nextRow<0||nextRow>= matrix.length){
                nextRow = nextRow<0 ? matrix.length-1 :0;
            }else {
                nextCol = nextCol < 0 ? matrix[nextRow].length - 1 : 0;
            }
            //nextRow<0||nextRow>=size
            //nextCol<0||nextCol>=size
        }
        if (matrix[nextRow][nextCol]=='T'){
            return;
        }else if (matrix[nextRow][nextCol]=='B'){
            matrix[Row][Col]='-';
            Row = nextRow;
            Col = nextCol;
            movePlayer(matrix,rowMutator,colMutator);
            return;
        }else if (matrix[nextRow][nextCol]=='F'){
            hasWon = true;
        }

        if (matrix[Row][Col]!='S'){
            matrix[Row][Col]='-';
        }

        matrix[nextRow][nextCol] = 'S';
        Row = nextRow;
        Col = nextCol;

    }
}