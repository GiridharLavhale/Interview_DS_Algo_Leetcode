class Solution {
    public int missingMultiple(int[] nums, int k) {
        int multiple = k;

        while(true){
            boolean found = false;


            for(int val: nums){
                if(val == multiple){
                    found = true;
                    break;
                }    
            }

            
            if(!found){
                return multiple;
            }
            
            multiple += k;
        }

    }
}