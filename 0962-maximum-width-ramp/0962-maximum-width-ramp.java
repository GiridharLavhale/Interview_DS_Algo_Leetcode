class Solution {
    public int maxWidthRamp(int[] nums) {
       int n = nums.length;

       Stack<Integer> st = new Stack<>();

       for(int i = 0; i < n; i++){
            if(st.isEmpty() || nums[st.peek()] >= nums[i]){
                st.push(i);
            }
       }

       int ramp = 0;
       int j = n -1;


       while(j >= 0){
            while(!st.isEmpty() && nums[st.peek()] <= nums[j]){ // st.top() = i
                int i = st.peek();
                ramp = Math.max(ramp, j -i);
                st.pop();
            }
            j--;
       }

       return ramp;
    }
}