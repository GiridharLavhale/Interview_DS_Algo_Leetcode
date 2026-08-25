class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        int MaxLen = 0; // take Max Length for return 

        for(int i = 0; i < n; i++){
            HashSet<Integer> Even = new HashSet<>(); // Taken a unordered set  called Even and odd
            Set<Integer> odd = new HashSet<>();
            for(int j = i; j < n; j++){
                if(nums[j] % 2 == 0){ // for an Even
                    Even.add(nums[j]);
                }else{
                    odd.add(nums[j]); // For an odd
                }

                if(Even.size() == odd.size()){  // if size is == then take a max
                    MaxLen = Math.max(MaxLen, j-i+1);
                }
            }
        }

        return MaxLen; // simply return the max elememt 
        
    }
}