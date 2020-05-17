public class APFRQ2 {
    public static void main(String[] args) {
    
    }
}

/**
 * @author J.L.
 * APID: WYY5V618
 */
public class StringPatterns {
    //Part A
    public static String letterAndPattern(String letter, String pattern) {
        if (pattern.indexOf(letter) != -1) {
            String temp;
            for (int i = pattern.length() - 1; i >= 0; i--) {
                temp += pattern.substring(i, i + 1);
            }
            return temp;
        } else {
            return letter;
        }
    }
}

//Part B
/**
 * Add a third parameter that is an integer to `letterAndPattern`
 * such that: `public static String letterAndPattern(String letter, String pattern, integer n)`
 * Within the code of the method, add an if statement that executes the code from part A
 * only if `pattern.length() < n`, but return an empty string otherwise.
 */