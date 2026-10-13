class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        // Step 1: Square every element
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }

        // Step 2: Sort the array
        Arrays.sort(nums);

        // Step 3: Calculate the sum of the larger half
        long largeHalf = 0;
        for (int i = n / 2; i < n; i++) {
            largeHalf += nums[i];
        }

        // Step 4: Calculate the sum of the smaller half
        long smallHalf = 0;
        for (int i = 0; i < n / 2; i++) {
            smallHalf += nums[i];
        }

        // Step 5: Return the difference
        return largeHalf - smallHalf;
    }
}
        
