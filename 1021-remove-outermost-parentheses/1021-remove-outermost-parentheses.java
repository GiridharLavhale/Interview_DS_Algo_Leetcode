class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;

        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(count != 0) sb.append(ch);
                count++;
            }else{
                count--;
                if(count != 0){
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
        
    }
}