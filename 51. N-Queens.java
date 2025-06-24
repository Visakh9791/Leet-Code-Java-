import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, board, result, n);
        return result;
    }

    private void solve(int row, char[][] board, List<List<String>> result, int n) {
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q'; 
                solve(row + 1, board, result, n); 
                board[row][col] = '.'; 
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
       
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

       
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }

    
    public static void main(String[] args) {
        Solution nQueens = new Solution();
        int n = 4;
        List<List<String>> solutions = nQueens.solveNQueens(n);

        int count = 1;
        for (List<String> solution : solutions) {
            System.out.println("Solution " + count++);
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
