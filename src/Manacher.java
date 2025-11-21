import java.util.*;

public class Manacher {
    
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        
        // Step 1: Transform string - add '#' between characters
        // "abc" becomes "#a#b#c#"
        StringBuilder transformed = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            transformed.append(c).append("#");
        }
        String t = transformed.toString();
        
        // Step 2: Array to store palindrome radius at each position
        int[] radius = new int[t.length()];
        int center = 0;      // Center of rightmost palindrome
        int right = 0;       // Right boundary of rightmost palindrome
        int maxLen = 0;      // Maximum palindrome length found
        int maxCenter = 0;   // Center of maximum palindrome
        
        // Step 3: Expand around each center
        for (int i = 0; i < t.length(); i++) {
            // Mirror position of i with respect to center
            int mirror = 2 * center - i;
            
            // Use previously computed values if within right boundary
            if (i < right) {
                radius[i] = Math.min(right - i, radius[mirror]);
            }
            
            // Try to expand palindrome centered at i
            int left = i - (radius[i] + 1);
            int rightPos = i + (radius[i] + 1);
            
            while (left >= 0 && rightPos < t.length() && 
                   t.charAt(left) == t.charAt(rightPos)) {
                radius[i]++;
                left--;
                rightPos++;
            }
            
            // Update center and right if we expanded past right boundary
            if (i + radius[i] > right) {
                center = i;
                right = i + radius[i];
            }
            
            // Track maximum palindrome
            if (radius[i] > maxLen) {
                maxLen = radius[i];
                maxCenter = i;
            }
        }
        
        // Step 4: Extract the longest palindrome from original string
        int start = (maxCenter - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        String result = longestPalindrome(input);
        System.out.println("Longest palindromic substring: \"" + result + "\"");
        System.out.println("Length: " + result.length());
    }
}