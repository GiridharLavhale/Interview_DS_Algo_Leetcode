class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        // opening brackets
        for(char ch : s.toCharArray()){
            if(st.isEmpty()  || ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
                
            }else{
                // Closing brackets
                if (st.isEmpty()) {
                    return false;
                }

                if (ch == ')' && st.peek() == '(') {
                    st.pop();
                }
                else if (ch == '}' && st.peek() == '{') {
                    st.pop();
                }
                else if (ch == ']' && st.peek() == '[') {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }

        

        return st.isEmpty();
        
    }
}