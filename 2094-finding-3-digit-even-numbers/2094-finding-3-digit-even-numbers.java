class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        int n = digits.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(i == j || j == k || i == k){
                        continue;
                    }

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k] * 1;

                    if(num >= 100 && num % 2 == 0){
                        set.add(num);
                    }
                }
            }
        }

        List<Integer> resultlist = new ArrayList<>(set);
        Collections.sort(resultlist);

        int[] result = new int[resultlist.size()];
        for(int i = 0; i < resultlist.size(); i++){
            result[i] = resultlist.get(i);

        }

        return result;
        
    }
}