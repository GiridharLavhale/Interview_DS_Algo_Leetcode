class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();

        Stack<Integer> st = new Stack<>();

        int Score = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                st.push(Score);
                Score = 0;
            }else{ 
                if(s.charAt(i-1) == '('){ // )
                    Score = st.peek() + 1;
                }else{ // Nestedd ')'
                    Score = st.peek() + (2*Score);

                }
                st.pop();
            }   
        }

        return Score;
        
    }
}