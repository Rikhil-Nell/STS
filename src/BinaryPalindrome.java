public class BinaryPalindrome{

    public static boolean isBinaryPalindrome(int n){
        String binary = Integer.toBinaryString(n);
        String reversed = new StringBuilder(binary).reverse().toString();
        return binary.equals(reversed);
    }

    public static void main(String[] args) {
        System.out.println(isBinaryPalindrome(5));
    }
}