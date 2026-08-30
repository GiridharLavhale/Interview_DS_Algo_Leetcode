class Solution {
    public int minimumLength(String s) { // T.c = O(n) S.C = O(1)
        int n = s.length();

        int i = 0; 
        int j = s.length()-1;

        while(i < j && s.charAt(i) == s.charAt(j)){
            char ch = s.charAt(i);
            while( i < j && s.charAt(i) == ch){
                i++;
            }
            while( j >= i && s.charAt(j) == ch){
                j--;
            }
        }

        return j-i+1;
        
    }
}