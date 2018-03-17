public class Queens {

    private static boolean isRowAvailable(int[][] board, int coordinateX){
        for(int i = 0; i < board.length; i++){
            if(board[coordinateX][i] == 1)
                return false;
        }
        return true;
    }

    private static boolean isColumnAvailable(int[][] board, int coordinateY){
        for(int i = 0; i < board.length; i++){
            if(board[i][coordinateY] == 1)
                return false;
        }
        return true;
    }

    private static boolean isPlaceAvailable(int[][] board, int coordinateX, int coordinateY){
        if(board[coordinateX][coordinateY] == 1)
            return false;
        return true;
    }

    private static boolean isDiagonalAvailable(int[][] board, int coordinateX, int coordinateY){
        int i = coordinateX, j = coordinateY;
        int n = board.length;

        for(i = coordinateX, j = coordinateY; i >= 0 && j < n; i--, j++){
            if(board[i][j] == 1)
                return false;
        }

        for(i = coordinateX, j = coordinateY; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 1)
                return false;
        }

        for(i = coordinateX, j = coordinateY; i < n && j < n; i++, j++){
            if(board[i][j] == 1)
                return false;
        }

        for(i = coordinateX, j = coordinateY; i < n && j >= 0; i++, j--){
            if(board[i][j] == 1)
                return false;
        }
        return true;
    }

    private static boolean isAvailable(int[][] board, int coordinateX, int coordinateY){
        if(isRowAvailable(board, coordinateY) &&
           isColumnAvailable(board, coordinateX) &&
           isDiagonalAvailable(board, coordinateX, coordinateY) &&
           isPlaceAvailable(board, coordinateX, coordinateY))
            return true;
        return false;
    }

    private static void printBoard(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean solveProblem(int board[][], int coordinateX)
    {
        if (coordinateX >= board.length)
            return true;

        for (int i = 0; i < board.length; i++)
        {
            if (isAvailable(board, coordinateX, i))
            {
                board[i][coordinateX] = 1;

                if (solveProblem(board, coordinateX + 1) == true)
                    return true;

                board[i][coordinateX] = 0;
            }
        }

        return false;
    }

    private static boolean solveNQ()
    {
        int board[][] = {{0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
        };

        if (solveProblem(board, 0) == false)
        {
            System.out.print("Solution does not exist");
            return false;
        }

        printBoard(board);
        return true;
    }

    public static void main(String[] args) {
        Queens problem = new Queens();
        problem.solveNQ();
    }
}
