class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = nums1[0];
        for(int i = 1; i < nums1.length; i++){
            min = Math.min(min, nums1[i]);
        }
        
        if( min % 2 == 1){ // if minimum is odd, answer is true 
            return true;
        }

        //check if we can make all even in nums2
        for(int num : nums1){
            if(num % 2 == 1){
                return false;
            }
        }

        return true; // all nums2 will be even 
    }
}