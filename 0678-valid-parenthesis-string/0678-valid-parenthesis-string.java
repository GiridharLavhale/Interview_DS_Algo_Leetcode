class Solution {
    public boolean checkValidString(String s) { // Bottom up approch 
        int n = s.length();

        boolean[][] dp = new boolean[n + 1][n + 1];

        //Base case 
        dp[n][0] = true;

        // dp[i][open]

        for(int i = n - 1; i >= 0; i--){
            for(int open = 0; open <= n; open++){

                boolean isvalid = false;

                if(s.charAt(i) == '*'){
                    // * = '('
                    if(open + 1 < n){
                        isvalid |= dp[i+1][open+1];
                    }

                    // * = ''
                    isvalid |= dp[i+1][open];

                    // * = ')'
                    if(open > 0){
                        isvalid |= dp[i+1][open-1];
                    }

                }else if(s.charAt(i) == '('){ 
                    if(open + 1 < n){// for '('
                        isvalid |= dp[i+1][open+1];
                    }
                    
                }else if(open > 0){ // for ')'
                    isvalid |= dp[i+1][open-1];
                }

                dp[i][open] = isvalid;
            }

        }
        return dp[0][0];

        
    }
}