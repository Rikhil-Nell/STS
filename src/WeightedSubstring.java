import java.util.*;

class WeightedSubstring {
    /**
     * Finds distinct substrings where sum of character weights <= K
     * P: input string
     * Q: weight string where Q[i] = weight of character 'a'+i
     * K: maximum allowed weight sum
     */
    static int distinctSubString(String P, String Q, int K) {
        int N = P.length();
        HashSet<String> validSubstrings = new HashSet<>();
        
        // Generate all substrings with weight <= K
        for (int i = 0; i < N; i++) {
            int weightSum = 0;
            StringBuilder substring = new StringBuilder();
            
            for (int j = i; j < N; j++) {
                char currentChar = P.charAt(j);
                int charIndex = currentChar - 'a';
                
                // Add weight of current character
                weightSum += (Q.charAt(charIndex) - '0');
                substring.append(currentChar);
                
                // If weight exceeds K, stop extending this substring
                if (weightSum > K) {
                    break;
                }
                
                // Add valid substring to set
                validSubstrings.add(substring.toString());
            }
        }
        
        return validSubstrings.size();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Weighted Substring Tests ===\n");
        
        // Test 1: Basic example
        String P1 = "abcde";
        String Q1 = "12345678901234567890123456"; // weights for a-z
        int K1 = 3;
        System.out.println("Test 1:");
        System.out.println("P = \"" + P1 + "\"");
        System.out.println("Q = \"" + Q1.substring(0, 26) + "\"");
        System.out.println("K = " + K1);
        System.out.println("Distinct substrings with weight <= " + K1 + ": " + distinctSubString(P1, Q1, K1));
        printValidSubstrings(P1, Q1, K1);
        System.out.println();
        
        // Test 2: All same weight
        String P2 = "aaa";
        String Q2 = "2000000000000000000000000"; // 'a' has weight 2
        int K2 = 5;
        System.out.println("Test 2 - Repeated characters:");
        System.out.println("P = \"" + P2 + "\"");
        System.out.println("K = " + K2 + " (weight of 'a' = 2)");
        System.out.println("Distinct substrings: " + distinctSubString(P2, Q2, K2));
        printValidSubstrings(P2, Q2, K2);
        System.out.println();
        
        // Test 3: High weight characters
        String P3 = "xyz";
        String Q3 = "11111111111111111111111987"; // x=9, y=8, z=7
        int K3 = 10;
        System.out.println("Test 3 - High weight chars:");
        System.out.println("P = \"" + P3 + "\"");
        System.out.println("K = " + K3);
        System.out.println("Distinct substrings: " + distinctSubString(P3, Q3, K3));
        printValidSubstrings(P3, Q3, K3);
        System.out.println();
        
        // Test 4: Mixed weights
        String P4 = "abab";
        String Q4 = "1200000000000000000000000"; // a=1, b=2
        int K4 = 4;
        System.out.println("Test 4 - Pattern with duplicates:");
        System.out.println("P = \"" + P4 + "\"");
        System.out.println("K = " + K4);
        System.out.println("Distinct substrings: " + distinctSubString(P4, Q4, K4));
        printValidSubstrings(P4, Q4, K4);
        System.out.println();
        
        // Test 5: Single character
        String P5 = "a";
        String Q5 = "5000000000000000000000000";
        int K5 = 5;
        System.out.println("Test 5 - Single character:");
        System.out.println("P = \"" + P5 + "\"");
        System.out.println("K = " + K5);
        System.out.println("Distinct substrings: " + distinctSubString(P5, Q5, K5));
        System.out.println();
        
        // Test 6: No valid substrings
        String P6 = "abc";
        String Q6 = "9990000000000000000000000"; // All weights >= 9
        int K6 = 2;
        System.out.println("Test 6 - No valid substrings:");
        System.out.println("P = \"" + P6 + "\"");
        System.out.println("K = " + K6);
        System.out.println("Distinct substrings: " + distinctSubString(P6, Q6, K6));
        System.out.println();
        
        // Interactive mode
        System.out.println("=== Interactive Mode ===");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string P: ");
        String P = scanner.nextLine();
        System.out.print("Enter string Q (26 digits for a-z weights): ");
        String Q = scanner.nextLine();
        System.out.print("Enter value of K: ");
        int K = scanner.nextInt();
        
        System.out.println("\nOutput: " + distinctSubString(P, Q, K));
        printValidSubstrings(P, Q, K);
    }
    
    // Helper to display all valid substrings
    static void printValidSubstrings(String P, String Q, int K) {
        int N = P.length();
        HashSet<String> validSubstrings = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            int weightSum = 0;
            StringBuilder substring = new StringBuilder();
            
            for (int j = i; j < N; j++) {
                char currentChar = P.charAt(j);
                int charIndex = currentChar - 'a';
                weightSum += (Q.charAt(charIndex) - '0');
                substring.append(currentChar);
                
                if (weightSum > K) break;
                validSubstrings.add(substring.toString());
            }
        }
        
        List<String> sorted = new ArrayList<>(validSubstrings);
        Collections.sort(sorted);
        System.out.println("Valid substrings: " + sorted);
    }
}