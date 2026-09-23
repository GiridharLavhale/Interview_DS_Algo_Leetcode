class Solution {

    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        // Calculate the total sum of the array
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Instead of removing elements with sum x,
        // we find the longest subarray with sum:
        // total - x
        int target = total - x;

        // If target is 0, we need to remove
        // the entire array.
        if (target == 0) {
            return n;
        }

        int left = 0;
        int sum = 0;

        // Stores the longest subarray
        // having sum equal to target
        int maxLen = -1;

        for (int right = 0; right < n; right++) {

            // Expand the window
            sum += nums[right];

            // If sum becomes greater than target,
            // shrink the window from the left
            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            // If current window has the required sum,
            // update the longest length
            if (sum == target) {
                maxLen = Math.max(
                    maxLen,
                    right - left + 1
                );
            }
        }

        // No subarray with target sum was found
        if (maxLen == -1) {
            return -1;
        }

        // We keep the longest subarray,
        // and remove everything outside it.
        return n - maxLen;
    }
}

// class Solution {
//     public int minOperations(int[] nums, int x) {
//         int n = nums.length;
//         int sum = 0;
//         HashMap<Integer, Integer> mp = new HashMap<>();
//         mp.put(0, -1);
//         for (int i = 0; i < n; i++) {
//             sum += nums[i];
//             mp.put(sum, i);
//         }
//         if (sum < x)
//             return -1;
//         int restSum = sum - x;
//         int longest = Integer.MIN_VALUE;
//         sum = 0;
//         for (int i = 0; i < n; i++) {
//             sum += nums[i];
//             if (mp.containsKey(sum - restSum)) {
//                 longest = Math.max(longest, i - mp.get(sum - restSum));
//             }
//         }
//         return longest == Integer.MIN_VALUE ? -1 : n - longest;
//     }
// }