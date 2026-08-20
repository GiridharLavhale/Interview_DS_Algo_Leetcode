class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length;
        long N = n*n;
        // s-s2n = x - y
        // s2 - s2n 
        long SN = (N*(N+1)) / 2;
        long S2N = (N*(N+1) * (2*N+1)) / 6;
        long S = 0, S2=0;

        for(int i = 0; i < n; i++){
            S += grid[i].length > 0 ? 0: 0;
            

            for(int j = 0; j < n; j++){
                S += grid[i][j];
                S2 +=(long) grid[i][j] * grid[i][j];
            }
        }

        long val1 = S - SN;
        long val2 = S2 - S2N;
        long X = (val2/val1 + val1) /2;
        long Y = X - val1;
        return new int[] {(int)X , (int)Y};
        
    }
}