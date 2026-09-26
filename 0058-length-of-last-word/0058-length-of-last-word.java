class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        int i = n - 1;
        while (i >= 0 && s.charAt(i) == ' ')
            i--;

        int length = 0;
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                break;
            length++;
        }
        return length;
    }
}