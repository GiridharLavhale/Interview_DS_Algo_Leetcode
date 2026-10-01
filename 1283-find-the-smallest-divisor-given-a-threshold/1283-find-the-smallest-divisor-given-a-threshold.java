class Solution {
    private int SumByD(int[] nums, int Div, int threshold ){
        int sum = 0;
        for(int num : nums){
            sum += (num-1) / Div+1;  // Division happens 
        

            // Early Check 
            if(sum > threshold){
                return sum;
            }
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        int ans = -1;
        // Maximum posssible divisor 
        for(int num: nums){
            high = Math.max(high, num);
        }

        while( low <= high){
            int mid = low + (high - low) / 2;  // low + high / 2
            if(SumByD(nums, mid, threshold ) <= threshold){
                ans = mid; // if mid is answer 
                high = mid - 1; // need a smaller divisor

            }else{
                low = mid + 1; 
            }
        }
        return ans;
        
    }
}