class Solution {
    public int countCommas(int n) {
        //     int count = 1;
        //     if(n < 1000){ // from 1 to 999  there is no commas 
        //         return 0;

        //     }
            
        //     for(int num = 1000; num < n; num++){ // Cheking from 1000 to n
        //          count += 1;
        //     }

        //     return count;

        return Math.max(n - 999, 0);
    }
}