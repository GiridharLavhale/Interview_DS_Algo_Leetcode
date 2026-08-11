class Solution {
public:
    int missingInteger(vector<int>& nums) {
        int n = nums.size();

        unordered_set<int> st(begin(nums), end(nums));

        int Sequential = nums[0];
        for(int j = 1; j < n; j++){
            if(nums[j] == nums[j-1] + 1){
              Sequential += nums[j];
                
            }else{
                break;
            }
        } 

        while(st.count(Sequential)){ // O(n)
            Sequential++;
        }

        return Sequential;  
    }
};