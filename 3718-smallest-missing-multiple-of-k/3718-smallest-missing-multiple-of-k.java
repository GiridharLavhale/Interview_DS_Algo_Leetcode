class Solution {
    public int missingMultiple(int[] nums, int k) {
        // int multiple = k;    // iterative approch

        // while(true){
        //     boolean found = false;


        //     for(int val: nums){
        //         if(val == multiple){
        //             found = true;
        //             break;
        //         }    
        //     }

            
        //     if(!found){
        //         return multiple;
        //     }

        //     multiple += k;
        // }

        HashSet<Integer> s = new HashSet<>();

        for(int num: nums){
            s.add(num);
        }

        int multiple = k;

        while(s.contains(multiple)){
            multiple += k;

        }

        return multiple;

    }
}