public class Strobogrammatic {

    public static boolean isStrobogrammatic(String n){
        String pairs = "00 11 88 69 96";

        int left = 0, right = n.length() - 1;

        while(left <= right){
            String pair = "" + n.charAt(left) + n.charAt(right);
            if (!pairs.contains(pair)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("69"));    // true
        System.out.println(isStrobogrammatic("88"));    // true
        System.out.println(isStrobogrammatic("818"));   // true
        System.out.println(isStrobogrammatic("962"));   // false
        System.out.println(isStrobogrammatic("1691"));  // true
    }
}