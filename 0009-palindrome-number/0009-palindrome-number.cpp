class Solution {
public:
    bool isPalindrome(int x) {
        // Negative numbers are never palindromes.
        // Numbers ending in 0 (except 0 itself) cannot be palindromes.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // Reverse digits until reversedHalf is greater than or equal to x
        while (x > reversedHalf) {
            reversedHalf = (reversedHalf * 10) + (x % 10);
            x /= 10;
        }

        // For even-length numbers: x == reversedHalf (e.g., 12 == 12)
        // For odd-length numbers: x == reversedHalf / 10 (e.g., 12 == 123 / 10)
        return (x == reversedHalf) || (x == reversedHalf / 10);
        
    }
};