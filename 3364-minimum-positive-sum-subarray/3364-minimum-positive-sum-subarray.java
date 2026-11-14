//Approach-3 (Using Sliding Window and Multiset)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {

    // helper: insert one copy (multiset.insert)
    private void add(TreeMap<Integer, Integer> st, int val) {
        st.merge(val, 1, Integer::sum);
    }

    // helper: erase one copy (multiset.erase(multiset.find(val)))
    private void removeOne(TreeMap<Integer, Integer> st, int val) {
        int cnt = st.get(val);
        if (cnt == 1) st.remove(val);
        else st.put(val, cnt - 1);
    }

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        int[] prefixSum = new int[n];
        prefixSum[0] = nums.get(0);
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums.get(i);
        }

        TreeMap<Integer, Integer> st = new TreeMap<>();
        add(st, 0);

        int result = Integer.MAX_VALUE;

        for (int j = l - 1; j < n; j++) {
            if (j - l >= 0) {
                add(st, prefixSum[j - l]);
            }

            int outOld = j - r - 1;
            if (outOld >= 0) {
                removeOne(st, prefixSum[outOld]);
            } else if (outOld == -1) {
                removeOne(st, 0);
            }

            // largest value strictly less than prefixSum[j]
            Integer lower = st.lowerKey(prefixSum[j]);
            if (lower != null) {
                result = Math.min(result, prefixSum[j] - lower);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}