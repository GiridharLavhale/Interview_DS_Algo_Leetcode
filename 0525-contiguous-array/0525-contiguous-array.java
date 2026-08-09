class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int maxi = 0;
        int sum = 0;
        mpp.put(0, -1);
        for(int i =0; i < n; i++){
            if(nums[i] == 0){
                sum += -1;
            }else{
                sum += 1;

            }
            if(mpp.containsKey(sum)){
                maxi = Math.max(maxi, i - mpp.get(sum));
            }else{
                mpp.put(sum, i);
            }          
            
        }
        return maxi;
        
    }
}