class Solution {
    private int SumByD(int[] nums, int Div){
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += Math.ceil((double)(nums[i]) / (double)(Div));
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        int ans = -1;

        for(int num : nums){
            high = Math.max(high, num);
        }

        while( low <= high){
            int mid = low + (high - low) / 2;
            if(SumByD(nums, mid) <= threshold){
                ans = mid;
                high = mid - 1;

            }else{
                low = mid + 1;
            }
        }
        return ans;
        
    }
}