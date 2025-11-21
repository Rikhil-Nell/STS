import java.util.*;

class MoveCharToStart {
    /**
     * Moves all spaces to the beginning while maintaining 
     * relative order of non-space characters
     */
    static void moveChar(char[] str) {
        int i = str.length - 1;
        
        // Traverse from right to left, copy non-space chars to the end
        for (int j = i; j >= 0; j--) {
            if (str[j] != ' ') {
                str[i] = str[j];
                i--;
            }
        }
        
        // Fill remaining positions with spaces
        while (i >= 0) {
            str[i] = ' ';
            i--;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Move Spaces to Beginning Tests ===\n");
        
        // Test 1: Basic example
        test("hello world", "  helloworld");
        
        // Test 2: Multiple spaces
        test("I love  Java", "   IloveJava");
        
        // Test 3: Spaces at beginning
        test("  abc", "  abc");
        
        // Test 4: Spaces at end
        test("abc  ", "  abc");
        
        // Test 5: Spaces in between
        test("a b c d e", "     abcde");
        
        // Test 6: No spaces
        test("HelloWorld", "HelloWorld");
        
        // Test 7: All spaces
        test("     ", "     ");
        
        // Test 8: Single character
        test("a", "a");
        
        // Test 9: Single space
        test(" ", " ");
        
        // Test 10: Alternating spaces and chars
        test("a b c", "  abc");
        
        // Test 11: Multiple consecutive spaces
        test("hello    world", "     helloworld");
        
        // Test 12: Complex sentence
        test("Move all spaces to front", "    Moveallspacestofront");
        
        System.out.println("\n=== Interactive Mode ===");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inp = sc.nextLine();
        char[] str = inp.toCharArray();
        
        moveChar(str);
        
        System.out.println("Result: \"" + String.valueOf(str) + "\"");
    }
    
    // Helper method for testing
    static void test(String input, String expected) {
        char[] str = input.toCharArray();
        moveChar(str);
        String result = String.valueOf(str);
        
        boolean passed = result.equals(expected);
        String status = passed ? "✓ PASS" : "✗ FAIL";
        
        System.out.printf("%s | Input: \"%s\" -> Output: \"%s\"", 
            status, input, result);
        
        if (!passed) {
            System.out.printf(" (Expected: \"%s\")", expected);
        }
        System.out.println();
    }
}