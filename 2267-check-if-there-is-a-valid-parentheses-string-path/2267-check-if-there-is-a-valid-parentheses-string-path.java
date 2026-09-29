class Solution {  // Bottom up T.C = O(m*n*(m+n)) S.C = O(m*n*(m+n))
    int m, n;
    boolean[][][] t;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if((m+n-1) % 2 == 1){
            return false;
        }

        if(grid[0][0] == ')' || grid[m-1][n-1] == '('){
            return false;
        }

        t = new boolean[m][n][201];

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                for(int openCount = 0; openCount <= i+j+1; openCount++){
                    if(i == m-1 && j == n-1){
                        t[i][j][openCount] = (openCount == 0);
                        continue;
                    }

                    t[i][j][openCount] = false;

                    // move down 
                    if(i+1 < m){
                        int newopenCount = (grid[i+1][j] == '(')? openCount + 1 : openCount - 1;
                        if(newopenCount >=0 && t[i+1][j][newopenCount]){
                            t[i][j][openCount] = true;
                            
                        }
                    }
                    // move right 
                    if(j+1 < n){
                        int newopenCount = (grid[i][j+1] == '(')? openCount + 1 : openCount - 1;
                        if(newopenCount >=0 && t[i][j+1][newopenCount]){
                            t[i][j][openCount] = true;
                        }
                    }
                }
            }
        }

        return t[0][0][1];
        
    }
}