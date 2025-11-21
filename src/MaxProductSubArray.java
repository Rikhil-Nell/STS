import java.util.*;
public class MaxProductSubArray {
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // When multiplied by negative, max becomes min and vice versa
            if (nums[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            
            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);
            
            result = Math.max(result, maxProd);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Max Product Subarray Test Suite ===\n");
        
        // Test 1: Basic positive numbers
        test(new int[]{2, 3, -2, 4}, 6, "Basic mixed");
        
        // Test 2: All negative becomes positive
        test(new int[]{2, 5, -15}, 10, "Your example");
        
        // Test 3: Single negative ruins product
        test(new int[]{-2}, -2, "Single negative");
        
        // Test 4: Two negatives make positive
        test(new int[]{-2, -3}, 6, "Two negatives");
        
        // Test 5: Multiple negatives
        test(new int[]{-2, 3, -4}, 24, "Three elements with negatives");
        
        // Test 6: Contains zero
        test(new int[]{-2, 0, -1}, 0, "Contains zero");
        
        // Test 7: All zeros
        test(new int[]{0, 0, 0}, 0, "All zeros");
        
        // Test 8: Zero splits array
        test(new int[]{2, 3, 0, 4, 5}, 20, "Zero in middle");
        
        // Test 9: Large positive product
        test(new int[]{2, 3, 4, 5}, 120, "All positive");
        
        // Test 10: All negative (odd count)
        test(new int[]{-1, -2, -3, -4, -5}, 120, "Odd negatives");
        
        // Test 11: Mix with zero at end
        test(new int[]{-2, 3, -4, 0}, 24, "Zero at end");
        
        // Test 12: Large array with pattern
        test(new int[]{1, 2, -3, 4, -5, 6, -7}, 5040, "Alternating signs");
        
        // Test 13: Edge case - single element
        test(new int[]{5}, 5, "Single positive");
        
        // Test 14: Negative sandwich
        test(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 960, "Complex pattern");
        
        // Test 15: Large numbers
        test(new int[]{100, -2, 50}, 100, "Large numbers");
        
        System.out.println("\n=== All tests completed! ===");
    }
    
    private static void test(int[] nums, int expected, String description) {
        int result = maxProduct(nums);
        String status = result == expected ? "✓ PASS" : "✗ FAIL";
        System.out.printf("%s - %s: %s (Expected: %d, Got: %d)\n", 
            status, description, Arrays.toString(nums), expected, result);
    }
}