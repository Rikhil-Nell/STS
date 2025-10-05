public class TwoNibbles {
    
    public static int swapNibbles(int n) {
        return ((n & 0x0F) << 4) | ((n & 0xF0) >> 4);
    }
    
    public static void main(String[] args) {
        System.out.println(swapNibbles(100));  // 70
        System.out.println(swapNibbles(129));  // 24
        System.out.println(swapNibbles(240));  // 15
        System.out.println(swapNibbles(15));   // 240
    }
}
