// T.C : (O(n) time : Two Pointer Technique)
// S.C : O(n), extra s taken
/*
    In this approach, you just need to find sections like this
    X .   .   .   . X
    i                j
    Where X can be 'R' or 'L' and in between there can be as many dots
    Now,
    - you know the length of mid part
    - If char[i] == char[j] == 'R', means all go towards right (R)
    -  char[i]  == char[j] == 'L', means all go towards Left (L)
    -  If char[i] = 'L' and char[j] = 'R', means middle part is not affected so they remain '.'
    -  If char[i] = 'R' and char[j] = 'L', then it will affect the middle part.
       The middle_part/2 close to i will be affected by 'R' and middle_part/2 close to j will be   
       effected by 'L'  and the last mid point (middle_part%2) will be unaffected due to equal  
       force from left and right so it remains '.'
*/
class Solution {
    public String pushDominoes(String dominoes) {
        String s = "L" + dominoes + "R";
        int n = s.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0, j = 1; j < n; j++) {
            if (s.charAt(j) == '.') continue;

            int midPartLength = j - i - 1;
            if (i > 0)
                result.append(s.charAt(i));

            if (s.charAt(i) == s.charAt(j))
                result.append(String.valueOf(s.charAt(i)).repeat(midPartLength));
            else if (s.charAt(i) == 'L' && s.charAt(j) == 'R')
                result.append(".".repeat(midPartLength));
            else {
                int half = midPartLength / 2;
                result.append("R".repeat(half));
                if (midPartLength % 2 == 1) result.append('.');
                result.append("L".repeat(half));
            }

            i = j;
        }

        return result.toString();
    }
}

// // T.C : (O(n) time : Finding closest 'L' and closest 'R')
// // S.C : O(n)
// class Solution {
//     public String pushDominoes(String dominoes) {
//         int n = dominoes.length();

//         int[] rightClosestL = new int[n];
//         int[] leftClosestR = new int[n];

//         // Moving right to left to find rightClosestL
//         for (int i = n - 1; i >= 0; i--) {
//             if (dominoes.charAt(i) == 'L')
//                 rightClosestL[i] = i; // L starts from me
//             else if (dominoes.charAt(i) == '.')
//                 rightClosestL[i] = i < n - 1 ? rightClosestL[i + 1] : -1;
//             else
//                 rightClosestL[i] = -1;
//         }

//         // Moving left to right to find leftClosestR
//         for (int i = 0; i < n; i++) {
//             if (dominoes.charAt(i) == 'R')
//                 leftClosestR[i] = i; // R starts from me
//             else if (dominoes.charAt(i) == '.')
//                 leftClosestR[i] = i > 0 ? leftClosestR[i - 1] : -1;
//             else
//                 leftClosestR[i] = -1;
//         }

//         StringBuilder result = new StringBuilder();

//         for (int i = 0; i < n; i++) {
//             int distRightL = rightClosestL[i] == -1 ? Integer.MAX_VALUE : Math.abs(i - rightClosestL[i]);
//             int distLeftR = leftClosestR[i] == -1 ? Integer.MAX_VALUE : Math.abs(i - leftClosestR[i]);

//             if (rightClosestL[i] == leftClosestR[i])
//                 result.append('.');
//             else if (rightClosestL[i] == -1)
//                 result.append('R');
//             else if (leftClosestR[i] == -1)
//                 result.append('L');
//             else if (distLeftR == distRightL)
//                 result.append('.');
//             else
//                 result.append(distRightL < distLeftR ? 'L' : 'R');
//         }

//         return result.toString();
//     }
// }
