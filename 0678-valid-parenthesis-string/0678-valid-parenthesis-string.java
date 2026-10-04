class Solution {
    int[][] t = new int[101][101];
    public boolean solve(int idx, int open, String s, int n){
        if(idx  == n){ // Base Case 
            return open == 0;
        }
        if(t[idx][open] != -1){
            return t[idx][open] == 1;
        }

        boolean isvalid = false;
        if(s.charAt(idx) == '*'){
            isvalid |= solve(idx+1, open+1, s, n); // for right open 
            isvalid |= solve(idx+1, open, s, n); // for Empty String 

            if(open > 0){ 
                isvalid |= solve(idx+1, open-1, s, n); // for left close 
            }
        }else if(s.charAt(idx) == '('){  // for open 
            isvalid |= solve(idx+1, open+1, s, n);
        }else if(open > 0){  // For Close 
            isvalid |= solve(idx+1, open-1, s, n);
        }

        t[idx][open] = isvalid ? 1 : 0;

        return isvalid;
        
    }
    public boolean checkValidString(String s) {
        int n = s.length();

        for(int[] rows : t){
            Arrays.fill(rows, -1);
        }

        return solve(0, 0, s, n); // passig values 

        
        
    }
}