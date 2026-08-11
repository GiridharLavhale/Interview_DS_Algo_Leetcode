class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

        HashSet<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }

        int Sequential = nums[0];
        for(int j = 1; j < n; j++){
            if(nums[j] == nums[j-1] + 1){
              Sequential += nums[j];
                
            }else{
                break;
            }
        } 

        while(st.contains(Sequential)){ // O(n)
            Sequential++;
        }

        return Sequential;  
        
    }
}