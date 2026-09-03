class Solution {
    public char findTheDifference(String s, String t) {
        int XOR = 0;

        for(char ch: s.toCharArray()){
            XOR ^= ch;

        }
        for( char ch: t.toCharArray()){
            XOR ^= ch;
        }

        return (char)XOR;
    }
}