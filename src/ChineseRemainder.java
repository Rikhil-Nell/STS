public class ChineseRemainder{
    
    public static int modInverse(int a, int m){
        for(int x = 1; x < m; x++){
            if((a * x) % m == 1){
                return x;
            }
        }
        return 1;
    }

    public static int crt(int[] rem, int[] mod){
        int M = 1;
        
        for(int i = 0; i < mod.length; i++){
            M *= mod[i];
        }

        int result = 0;

        for(int i = 0; i < mod.length; i++){
            int Mi = M / mod[i];
            int yi = modInverse(Mi, mod[i]);
            result += rem[i] * Mi * yi;
        }

        return result % M;
    }

    public static void main(String[] args) {
        int rem[] = {2, 3, 1};
        int mod[] = {3, 4, 5};
        
        System.out.println("x is " + crt(rem, mod));
    }
}