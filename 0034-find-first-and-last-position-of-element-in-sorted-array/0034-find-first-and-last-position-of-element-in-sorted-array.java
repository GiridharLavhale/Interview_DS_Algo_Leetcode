class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findfirst(nums,target);
        result[1] = findLast(nums, target);
        return result;
    }


    private int findfirst(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
        
            // may be an answer 
            if(nums[mid] == target ){
                ans = mid;
                // look for small index on left 
                high = mid - 1;
            }else if(nums[mid] < target){
                
                  low = mid + 1; // look for right 
            }else{
                high = mid - 1;
            }
        }
        return ans;
        
    }

    private int findLast(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while(low <= high){
            int mid = (low + high) / 2;
        
            // may be an answer 
            if(nums[mid] == target ){
                ans = mid;
                // look for small index on left 
                low = mid + 1;
            }else if(nums[mid] < target){
                
                  low = mid + 1; // look for right 
            }else{
                high = mid - 1;
            }
        }
        return ans;
        
    }
}