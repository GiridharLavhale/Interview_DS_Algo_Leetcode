class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int L = 1;
        int MaxEl = nums[0];
        int MinEl = nums[0];
        int i = 0;
        int j = 0;

        while(j < n){
            MaxEl = nums[j];
            MinEl = nums[i];

            while(i <= j && MaxEl > (long) k*MinEl){
                i++;
                MinEl = nums[i];
            }

            L = Math.max(L, j-i+1);
            j++;
        }

        return n - L; // Deletions 
        
    }
}