class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();

        if (numFriends == 1) {
            return word;
        }

        int longestpossible = n - (numFriends-1);
        String result = " ";

        for(int i = 0; i < n; i++){
            int canTakeLength = Math.min(longestpossible, n-i);
           
           String current = word.substring(i, i + canTakeLength);

            if (current.compareTo(result) > 0) {
                result = current;
            }
        }

        return result;
        
    }
}