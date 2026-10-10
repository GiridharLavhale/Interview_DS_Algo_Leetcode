class Solution {
    boolean ispossible(int[] nums, int k, int Maxallowtime){
        int painters = 1, time = 0;
        for(int i = 0; i < nums.length; i++){
            if(time + nums[i] <= Maxallowtime){
                time += nums[i];
            }else{
                painters++;
                time = nums[i];
            }
        }

        return painters <= k;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, maxval = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            maxval = Math.max(maxval, nums[i]);
        }
        
        int low = maxval, high = sum, ans = -1;

        while( low <= high){
            int mid = low + ( high - low ) / 2;
            if(ispossible( nums, k , mid )){ //left 
                ans = mid;
                high = mid - 1;
            }else{ //right 
                low = mid + 1;
            }
        }

        return ans;
    }
}