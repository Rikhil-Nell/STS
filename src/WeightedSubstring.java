import java.util.*;

class WeightedSubstring {
    static int distinctSubString(String P, String Q, int K) {
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
                
                if (weightSum > K) {
                    break;
                }
                
                validSubstrings.add(substring.toString());
            }
        }
        
        return validSubstrings.size();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string P: ");
        String P = scanner.nextLine();
        System.out.print("Enter string Q (26 digits for a-z weights): ");
        String Q = scanner.nextLine();
        System.out.print("Enter maximum weight K: ");
        int K = scanner.nextInt();
        
        System.out.println("Number of distinct substrings with weight <= " + K + ": " + distinctSubString(P, Q, K));
    }
}