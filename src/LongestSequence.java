public class LongestSequence {
    
    public static int longestSequenceOfOnes(int n) {
        if (n == 0) {
            return 1;  // Flipping a single bit creates a sequence of length 1
        }
        
        int maxLength = 0;
        int currentLength = 0;
        int previousLength = 0;
        
        while (n != 0) {
            if ((n & 1) == 1) {
                currentLength++;  // Count consecutive 1s
            } else {
                previousLength = (n & 2) == 0 ? 0 : currentLength;  // Handle flipping
                currentLength = 0;
            }
            maxLength = Math.max(maxLength, previousLength + currentLength + 1);  // Flip one bit
            n >>= 1;  // Right shift to process next bit
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        System.out.println(longestSequenceOfOnes(1775));  // 8 (binary: 11011101111)
        System.out.println(longestSequenceOfOnes(15));    // 5 (binary: 1111)
        System.out.println(longestSequenceOfOnes(0));     // 1 (binary: 0)
        System.out.println(longestSequenceOfOnes(1));     // 2 (binary: 1)
    }
}
