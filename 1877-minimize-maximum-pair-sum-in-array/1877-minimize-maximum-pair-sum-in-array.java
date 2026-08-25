class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int res = 0;
        int sum = 0;
        while(i < j){
            sum = nums[i] + nums[j];
            res = Math.max(res,sum);
            i++;
            j--;
        }

        return res;
        
    }
}