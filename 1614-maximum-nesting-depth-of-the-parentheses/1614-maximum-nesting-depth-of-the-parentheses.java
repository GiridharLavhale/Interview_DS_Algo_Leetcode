//Approach-1 (using stack)
//T.C : O(n)
//S.C : O(n)
public class Solution {
    public int maxDepth(String s) {
        int result = 0;
        Stack<Character> st = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                st.pop();
            }
            
            result = Math.max(result, st.size());
        }
        
        return result;
    }
}

// //Approach-2 (using constant space)
// //T.C : O(n)
// //S.C : O(1)
// public class Solution {
//     public int maxDepth(String s) {
//         int result = 0;
//         int openBrackets = 0;

//         for (char ch : s.toCharArray()) {
//             if (ch == '(') {
//                 openBrackets++;
//             } else if (ch == ')') {
//                 openBrackets--;
//             }
            
//             result = Math.max(result, openBrackets);
//         }
        
//         return result;
//     }
// }