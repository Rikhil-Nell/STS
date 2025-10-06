public class Euler{
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }

    public static int etf(int n){
        int result = 1;

        for(int i = 2; i <= n; i++){
            if(gcd(i, n) == 1){
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(etf(60));
    }
}