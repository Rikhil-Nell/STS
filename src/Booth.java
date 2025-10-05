public class Booth {
    
    public static int boothMultiplication(int m, int r) {
        int A = m;          // Multiplicand
        int Q = r;          // Multiplier
        int Q_1 = 0;        // Extra bit
        int count = 32;     // Number of bits (for int)
        int product = 0;
        
        while (count > 0) {
            // Check last two bits (Q0 and Q-1)
            int Q0 = Q & 1;
            
            if (Q0 == 1 && Q_1 == 0) {
                // 10: Subtract A
                product -= A;
            } else if (Q0 == 0 && Q_1 == 1) {
                // 01: Add A
                product += A;
            }
            // 00 or 11: Do nothing
            
            // Arithmetic right shift
            Q_1 = Q0;
            Q = Q >> 1;
            A = A << 1;
            
            count--;
        }
        
        return product;
    }
    
    public static void main(String[] args) {
        System.out.println(boothMultiplication(155, -900));      // 21
        System.out.println(boothMultiplication(-7, 3));     // -21
        System.out.println(boothMultiplication(7, -3));     // -21
        System.out.println(boothMultiplication(-7, -3));    // 21
    }
}
