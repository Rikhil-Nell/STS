public class Euclid {
    
    public static int gcd(int a, int b) {
        // Base case: if b is 0, gcd is a
        if (b == 0) {
            return a;
        }
        // Recursive case: gcd(a, b) = gcd(b, a % b)
        return gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        System.out.println(gcd(48, 18));  // 6
        System.out.println(gcd(56, 98));  // 14
        System.out.println(gcd(101, 103)); // 1
        System.out.println(gcd(270, 192)); // 6
    }
}
