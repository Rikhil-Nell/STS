import java.util.*;

public class Sieve{

    public static void sieve(int num){

        boolean[] prime = new boolean[num + 1];

        Arrays.fill(prime, true);

        for (int i = 2; i*i <= num; i++){
            if (prime[i]){
                for (int j = i*i; j <= num; j += i){
                    prime[j] = false;
                }
            }
        }

        for (int k = 2; k <= num; k++){
            if (prime[k]){
                System.out.println(k + " ");
            }
        }
    }

    public static void main(String[] args) {
        sieve(100);
    }
}