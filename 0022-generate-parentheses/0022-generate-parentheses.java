class Solution {
    public List<String> generateParenthesis(int n){
     List<String> result = new ArrayList<>();
        generate("", n, 0, result);
        return result;
    }

    // Function to check if the parentheses are valid
    private boolean isValid(String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(')
                sum++;
            else
                sum--;
            if (sum < 0)
                return false;
        }
        return sum == 0;
    }

    // Recursive function to generate parentheses
    private void generate(String curr, int n, int length, List<String> result) {
        if (length == 2 * n) {
            if (isValid(curr))
                result.add(curr);
            return;
        }

        curr += '(';
        generate(curr, n, length + 1, result);
        curr = curr.substring(0, curr.length() - 1); // remove the last character

        curr += ')';
        generate(curr, n, length + 1, result);
    }
}

          
