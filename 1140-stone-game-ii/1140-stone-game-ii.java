class Solution {
    int n;
    int [][][] dp;
    public int solveForAlice(int[] piles, int per, int i, int M){
        if( i >= n){
            return 0;
        }
        if(dp[per][i][M] != -1){
            return dp[per][i][M];
        }
        int result = (per == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;

        for( int x= 1; x <= Math.min(2*M, n-i); x++){
            stones += piles[i+x-1];
            if(per == 1){
                result = Math.max(result, stones + solveForAlice(piles, 0, i+x, Math.max(M,x)));
            }else{
                result = Math.min(result, solveForAlice(piles, 1, i+x, Math.max(M,x)));
            }
        }

        return dp[per][i][M]=result;
    }
    public int stoneGameII(int[] piles) {
        n = piles.length;

        dp = new int[2][n][n+1];
        for(int p = 0; p<2; p++){
            for(int i = 0; i < n; i++){
                Arrays.fill(dp[p][i], -1);
            }
        }

        return solveForAlice(piles, 1, 0, 1);
    

    }
}