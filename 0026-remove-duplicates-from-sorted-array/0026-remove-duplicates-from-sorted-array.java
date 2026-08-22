class Solution {
    public int removeDuplicates(int[] nums) {
        // int i = 0; 
        // for(int j = 1; j < nums.length; j++){
        //     if(nums [i] != nums[j] ){
        //         nums [i+1] = nums[j];
        //         i++;
                
        //     }
        // }
        // return i+1;

        int n = nums.length;
        int i = 0 , j = 1;
        while( j < n){
            if( nums[i] != nums[j]){ // got the unique element
                i++;
                nums[i] = nums[j];
            }else{
                j++; // to find unique elements
            }
        }

        return i+1;
        
    }
}