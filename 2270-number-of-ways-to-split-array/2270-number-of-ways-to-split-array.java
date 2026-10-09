//Approach-2 (Using cummulativeSum array/Prefix Sum Array)
//T.C : O(N)
//S.C : O(1)
class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

        // Calculate the total sum of the array
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long leftSum = 0;
        long rightSum = 0;
        int split = 0;

        // Iterate through the array to calculate leftSum and rightSum
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;

            if (leftSum >= rightSum) {
                split++;
            }
        }

        return split;
    }
}