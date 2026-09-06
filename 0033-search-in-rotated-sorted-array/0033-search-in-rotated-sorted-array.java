class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while( low <= high){
            int mid = (low + high) >> 1;
            if(nums[mid] == target){
                return mid;
            }

            // The left side is sorted or not 
            if(nums[low] <= nums[mid]){
                // figure out if element lies on the left half or not 
                if(target >= nums[low] && target <= nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
              // right half is sorted   
            }else if(target >= nums[mid] && target <= nums[high]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
                
            
        }

        return -1;
    }
}