import java.io.*;
import java.util.*;

class MaxSumOfHourglass {
    static int findMaxSum(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        // Validate matrix dimensions
        if (rows < 3 || cols < 3) {
            throw new IllegalArgumentException("Matrix must be at least 3x3 to contain an hourglass");
        }
        
        int maxSum = Integer.MIN_VALUE;
        
        // Iterate through all possible hourglass positions
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                // Calculate hourglass sum at position (i, j)
                int sum = mat[i][j] + mat[i][j + 1] + mat[i][j + 2]     // Top row
                        + mat[i + 1][j + 1]                               // Middle
                        + mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2]; // Bottom row
                
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Hourglass Maximum Sum Tests ===\n");
        
        // Test 1: Your example
        int[][] mat1 = {
            {1, 2, 3, 0, 0},
            {0, 0, 0, 0, 0},
            {2, 1, 4, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 0}
        };
        System.out.println("Test 1 - Your example:");
        printMatrix(mat1);
        System.out.println("Maximum hourglass sum = " + findMaxSum(mat1) + "\n");
        
        // Test 2: All positive numbers
        int[][] mat2 = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0}
        };
        System.out.println("Test 2 - HackerRank classic:");
        printMatrix(mat2);
        System.out.println("Maximum hourglass sum = " + findMaxSum(mat2) + "\n");
        
        // Test 3: Contains negative numbers
        int[][] mat3 = {
            {-1, -1, 0, -9, -2, -2},
            {-2, -1, -6, -8, -2, -5},
            {-1, -1, -1, -2, -3, -4},
            {-1, -9, -2, -4, -4, -5},
            {-7, -3, -3, -2, -9, -9},
            {-1, -3, -1, -2, -4, -5}
        };
        System.out.println("Test 3 - All negative:");
        printMatrix(mat3);
        System.out.println("Maximum hourglass sum = " + findMaxSum(mat3) + "\n");
        
        // Test 4: Mixed positive and negative
        int[][] mat4 = {
            {3, 7, -3},
            {-2, 5, 8},
            {4, -1, 2}
        };
        System.out.println("Test 4 - 3x3 matrix (single hourglass):");
        printMatrix(mat4);
        System.out.println("Maximum hourglass sum = " + findMaxSum(mat4) + "\n");
        
        // Test 5: Large values
        int[][] mat5 = {
            {100, 200, 300, 400},
            {500, 600, 700, 800},
            {900, 1000, 1100, 1200},
            {1300, 1400, 1500, 1600}
        };
        System.out.println("Test 5 - Large numbers:");
        printMatrix(mat5);
        System.out.println("Maximum hourglass sum = " + findMaxSum(mat5) + "\n");
        
        // Test 6: Edge case - exactly 3x3
        int[][] mat6 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Test 6 - Minimal 3x3:");
        printMatrix(mat6);
        System.out.println("Maximum hourglass sum = " + findMaxSum(mat6) + "\n");
        
        System.out.println("=== All tests completed! ===");
    }
    
    // Helper method to print matrix nicely
    static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.printf("%5d ", val);
            }
            System.out.println();
        }
    }
}