class Solution {
    public boolean checkBalanced(int[] freq){
        int common = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] == 0){
                continue;
            }
            if(common == 0){
                common = freq[i];
            }else if(freq[i] != common){
                return false;
            }
        }

        return true;

    }
    public int longestBalanced(String s) {

        int n = s.length();

        int MaxL = 0;

        for(int i = 0; i < n; i++){
            int[] freq = new int[26];
            for(int j = i; j < n; j++){
                freq[s.charAt(j) - 'a']++;

                if(checkBalanced(freq)){
                    MaxL = Math.max(MaxL, j-i+1);
                }
            }
        }

        return MaxL;
        
    }
}