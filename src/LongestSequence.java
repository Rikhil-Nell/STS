public class LongestSequence {
    
    public static int longestSequenceOfOnes(int n){
        if (n == 0){
            return 1;
        }

        int maxLength = 0;
        int currentLength = 0;
        int previousLength = 0;

        while(n != 0){
            if ((n & 1) == 1){
                currentLength++;
            }
            else{
                previousLength = (n & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(maxLength, previousLength + currentLength + 1);
            n >>= 1;
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
