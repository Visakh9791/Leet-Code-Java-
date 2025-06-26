class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }

      return matrix;
    }
    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution sm = new Solution();
        int n = 3;
        int[][] result = sm.generateMatrix(n);
        sm.printMatrix(result);
    }
}
   
    
