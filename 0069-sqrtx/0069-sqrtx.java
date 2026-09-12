class Solution {
    public int mySqrt(int x) {

        int low = 1;
        int high = x; // n 

        while( low <= high){
            int mid = low + (high - low ) / 2;
            long val = (long) mid *mid;
            if(val <= x){
                
                low = mid + 1;
            }else{
                high = mid - 1;
            }

        }

        return high;
        
    }
}