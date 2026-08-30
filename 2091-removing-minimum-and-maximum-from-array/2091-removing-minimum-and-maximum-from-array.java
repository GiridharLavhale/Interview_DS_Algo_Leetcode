class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        // int minElidx = Arrays.stream(nums).min().getAsInt();
        // int maxElidx = Arrays.stream(nums).max().getAsInt();
        int minElidx = 0;
        int maxElidx = 0;
        for(int i =0; i<n; i++){
            // minElidx = Math.min(minElidx, nums[i]);
            // maxElidx = Math.max(maxElidx, nums[i]);
            if (nums[i] < nums[minElidx]) minElidx = i;
            if (nums[i] > nums[maxElidx]) maxElidx = i;
        }

        int left = Math.min(minElidx , maxElidx);
        int right = Math.max(minElidx , maxElidx);

        return Math.min(left+1+n-right, Math.min(right+1 , n-left ));
        
    }
}