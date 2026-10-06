class Solution {
    public int minAddToMakeValid(String s) {

        // int size = 0;
        // int open = 0;
        // for(char ch: s.toCharArray()){
        //     if(ch == '('){ // if open bracket present then count size++
        //         size++;
        //     }else if(size > 0){ // if ')' is there then check size > 0 then size--
        //         size --;
        //     }else{  // if closing is present then open++
        //         open++;
        //     }
        // }

        // return open + size;

        Stack<Character> st = new Stack<>();
        int needopen = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }else{
                if(!st.isEmpty()){
                    st.pop();
                }else{
                    needopen++;
                }
            }
        }

        return st.size() + needopen ;



        
    }
}