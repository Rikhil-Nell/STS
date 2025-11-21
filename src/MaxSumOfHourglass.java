import java.io.*;
import java.util.*;

class MaxSumOfHourglass {
    static int findMaxSum(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        if (rows < 3 || cols < 3) {
            throw new IllegalArgumentException("Matrix must be at least 3x3");
        }
        
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                int sum = mat[i][j] + mat[i][j + 1] + mat[i][j + 2]
                        + mat[i + 1][j + 1]
                        + mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2];
                
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        
        int[][] mat = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Maximum hourglass sum: " + findMaxSum(mat));
    }
}