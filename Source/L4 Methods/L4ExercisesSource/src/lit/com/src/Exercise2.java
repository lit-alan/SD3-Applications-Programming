package lit.com.src;


public class Exercise2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int max = 1;
        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= 100; j--) {
                int temp = i * j;
                if (max < temp) {
                    if (isPalindrome(temp)) {
                        max = temp;
                        break;
                    }
                } else {
                    break;
                }
            }//end for
        }//end for

        System.out.println(max);
    }//end main

    private static boolean isPalindrome(int n) {
        int palindrome = n;
        int reverse = 0;

        // Compute the reverse
        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // The integer is palindrome if n and reverse are equal
        return n == reverse;
    }
}
