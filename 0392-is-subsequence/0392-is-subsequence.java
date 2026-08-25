class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(); // length of nums1
        int n = t.length(); // len of nums2

        int i = 0, j = 0; // i & j pointer
        
        while(i < m && j < n){  
            if(s.charAt(i) == t.charAt(j)){  // s ka element t me hai ki nahi 
                i++; // found the required character

            }
               
            j++; // always move through t 
            
        }
        return i == m;

        
    }
}