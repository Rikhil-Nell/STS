import java.util.*;

public class SegmentedSieve {
    
    public static void segSieve(int l, int h) {
        // Regular sieve up to h
        boolean[] prime = new boolean[h + 1];
        Arrays.fill(prime, true);
        
        prime[0] = prime[1] = false;
        
        for(int p = 2; p * p <= h; p++) {
            if(prime[p]) {
                for(int i = p * p; i <= h; i += p) {
                    prime[i] = false;
                }
            }
        }
        
        // Only print primes in range [l, h]
        System.out.print("Primes between " + l + " and " + h + ": ");
        for(int i = l; i <= h; i++) {
            if(prime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        segSieve(10, 30);
        segSieve(100, 150);
    }
}