import java.util.*;

class MoveCharToStart {
    static void moveChar(char[] str) {
        int i = str.length - 1;
        
        for (int j = i; j >= 0; j--) {
            if (str[j] != ' ') {
                str[i] = str[j];
                i--;
            }
        }
        
        while (i >= 0) {
            str[i] = ' ';
            i--;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        char[] str = input.toCharArray();
        
        moveChar(str);
        
        System.out.println("String with spaces moved to beginning: \"" + String.valueOf(str) + "\"");
    }
}