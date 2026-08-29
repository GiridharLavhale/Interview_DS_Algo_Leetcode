class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        
        int[] rightMax = new int[n];
        rightMax[n-1] = nums[n-1];
        for( int i =n - 2; i >= 0; i-- ){
            rightMax[i] = Math.max(rightMax[i+1], nums[i]);
        }

        int ramp = 0;
        int i = 0; // nums 
        int j = 0;// right Max

        while(j < n){
            while(i < j && nums[i] > rightMax[j]){ // nums[i] <= nums[j]
                i++;

            }

            ramp = Math.max(ramp, j-i);
            j++;
        }

        return ramp;
    }
}