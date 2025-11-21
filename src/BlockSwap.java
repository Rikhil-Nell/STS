import java.util.*;
class BlockSwap {
  static void rotateArr(Integer[] arr, int d) {
    int n = arr.length;
    d = d % n;
    if (d == 0) return;
    
    List<Integer> list = Arrays.asList(arr);
    Collections.rotate(list, -d); // negative for left rotation
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Integer[] arr = new Integer[n];
    
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    
    rotateArr(arr, 4);
    
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}