public class BinaryPalindrome {
    
    public static boolean isBinaryPalindrome(int n) {

        // Use if the input is just binary
        // String binary = String.valueOf(n);

        // Convert decimal to binary string
        String binary = Integer.toBinaryString(n);
        
        // Check palindrome
        String reversed = new StringBuilder(binary).reverse().toString();
        return binary.equals(reversed);
    }
    
    public static void main(String[] args) {
        System.out.println(isBinaryPalindrome(5));     // true  (5 = 101 in binary)
        System.out.println(isBinaryPalindrome(9));     // true  (9 = 1001 in binary)
        System.out.println(isBinaryPalindrome(13));    // false (13 = 1101 in binary)
        System.out.println(isBinaryPalindrome(7));     // true  (7 = 111 in binary)
        System.out.println(isBinaryPalindrome(15));    // true  (15 = 1111 in binary)
    }
}
