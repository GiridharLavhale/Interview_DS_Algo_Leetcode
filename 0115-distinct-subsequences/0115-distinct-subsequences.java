// class Solution {
//     int[][] dp = new int[1001][1001];

//     int solve(String s, String t, int m, int n) {
//         if(n == 0)
//             return dp[m][n] = 1;

//         if(m == 0)
//             return dp[m][n] = 0;

        
//         if(dp[m][n] != -1)
//             return dp[m][n];

//         /*
//             (rabb) b (it)
//             (ra)   b (bbit)
//             (rab)  b (bit)
//             This can help to understand the if condition below
//         */
        
//         if(s.charAt(m-1) == t.charAt(n-1))
//             return dp[m][n] = solve(s, t, m-1, n) + solve(s, t, m-1, n-1);
//         else
//             return dp[m][n] = solve(s, t, m-1, n);
//     }


//     public int numDistinct(String s, String t) {
//         int m = s.length();
//         int n = t.length();

//         if(m < n)
//             return 0;
//         for(int[] row : dp)
//             Arrays.fill(row, -1);


//         return solve(s, t, m, n);
//     }
// }

//Approach-3 (Optimized Bottom UP DP)
/*
    If you notice, you are just requiring the previous row's value
    See the if condition    - dp[i-1][j-1] + dp[i-1][j]; //(i-1) points to previous row
    
    See the else condition  - dp[i-1][j]; //(i-1) points to previous row
    
    So, why not simply store previous value in a 1-D array
    We can then solve this qn, using O(m+n) space complexity
*/
//T.C : O(m*n)
//S.C : O(m + n)
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        long[] curr = new long[n+1];
        long[] prev = new long[n+1];
        
        prev[0] = curr[0] = 1;
        
        for(int i = 1; i<m+1; i++) {
            
            for(int j = 1; j<n+1; j++) {
                
                if(s.charAt(i-1) == t.charAt(j-1))
                    curr[j] = prev[j-1] + prev[j];
                else
                    curr[j] = prev[j];
            }
            prev = curr.clone();
        }
        return (int) prev[n];
    }
}