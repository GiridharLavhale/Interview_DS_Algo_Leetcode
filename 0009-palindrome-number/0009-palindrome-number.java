class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending in 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int lastDigit = x % 10;
            reversedHalf = reversedHalf * 10 + lastDigit;
            x = x / 10;
        }

        // Check for both even-length (e.g., 1221) and odd-length (e.g., 121) palindromes
        return x == reversedHalf || x == reversedHalf / 10;
        
    }
}