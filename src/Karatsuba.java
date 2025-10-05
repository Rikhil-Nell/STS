public class Karatsuba {
    
    public static int karatsuba(int x, int y) {
        // Split numbers into high and low parts
        int half = Math.max(Integer.toString(x).length(), Integer.toString(y).length()) / 2;
        int highX = x / (int) Math.pow(10, half);
        int lowX = x % (int) Math.pow(10, half);
        int highY = y / (int) Math.pow(10, half);
        int lowY = y % (int) Math.pow(10, half);
        
        // Compute the three products
        int z0 = lowX * lowY;
        int z2 = highX * highY;
        int z1 = (lowX + highX) * (lowY + highY) - z2 - z0;
        
        // Combine the results
        return (int) (z2 * Math.pow(10, 2 * half) + z1 * Math.pow(10, half) + z0);
    }
    
    public static void main(String[] args) {
        System.out.println(karatsuba(1234, 5678));  // 7006652
        System.out.println(karatsuba(12, 34));      // 408
        System.out.println(karatsuba(123, 456));    // 56088
    }
}