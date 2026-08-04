class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {

        int mn = *min_element(nums.begin(), nums.end()); 
        int mx = *max_element(nums.begin(), nums.end());  

        unordered_set<int> st(nums.begin(), nums.end()); // Store all array elements in a hash set for O(1) lookup

        vector<int> ans; 

        for (int i = mn; i <= mx; i++) {  
            if (st.find(i) == st.end()) { // if current number is not present in set then he is missing num
                ans.push_back(i);
            }
        }

        return ans; // return all missing
    }
};