class Solution {
    public int scoreOfParentheses(String s) {
        // int n = s.length(); // Using Stck so T.C = O(n) S.C = O(n)

        // Stack<Integer> st = new Stack<>();

        // int Score = 0;

        // for(int i = 0; i < n; i++){
        //     if(s.charAt(i) == '('){
        //         st.push(Score);
        //         Score = 0;
        //     }else{ 
        //         if(s.charAt(i-1) == '('){ // )
        //             Score = st.peek() + 1;
        //         }else{ // Nestedd ')'
        //             Score = st.peek() + (2*Score);

        //         }
        //         st.pop();
        //     }   
        // }

        // return Score;

        int n = s.length();

        int score = 0;
        int depth = 0;

        for( int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                depth++;
            }else{ //  s[i] == ')'
                depth--;
                if(s.charAt(i-1) == '('){
                    score += ( 1 << depth);
                }

            }
        }

        return score;
        
    }
}