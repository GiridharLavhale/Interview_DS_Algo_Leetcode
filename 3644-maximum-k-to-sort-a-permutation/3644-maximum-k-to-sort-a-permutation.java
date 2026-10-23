class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;

        int k = -1; // Taking all bits (means taking the long value )

        for(int i = 0; i < n; i++){
            if(nums[i] != i){
                k = (k & nums[i]);
            }
        }

        return k == -1 ? 0 : k;
        
    }
}