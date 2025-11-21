import java.util.*;

class BlockSwap {
    static void rotateArr(Integer[] arr, int d) {
        int n = arr.length;
        d = d % n;
        if (d == 0) return;
        
        List<Integer> list = Arrays.asList(arr);
        Collections.rotate(list, -d);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter rotation distance: ");
        int d = sc.nextInt();
        
        rotateArr(arr, d);
        
        System.out.print("Rotated array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}