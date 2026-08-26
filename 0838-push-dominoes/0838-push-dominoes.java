// T.C : (O(n) time : Finding closest 'L' and closest 'R')
// S.C : O(n)
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();

        int[] rightClosestL = new int[n];
        int[] leftClosestR = new int[n];

        // Moving right to left to find rightClosestL
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L')
                rightClosestL[i] = i; // L starts from me
            else if (dominoes.charAt(i) == '.')
                rightClosestL[i] = i < n - 1 ? rightClosestL[i + 1] : -1;
            else
                rightClosestL[i] = -1;
        }

        // Moving left to right to find leftClosestR
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R')
                leftClosestR[i] = i; // R starts from me
            else if (dominoes.charAt(i) == '.')
                leftClosestR[i] = i > 0 ? leftClosestR[i - 1] : -1;
            else
                leftClosestR[i] = -1;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int distRightL = rightClosestL[i] == -1 ? Integer.MAX_VALUE : Math.abs(i - rightClosestL[i]);
            int distLeftR = leftClosestR[i] == -1 ? Integer.MAX_VALUE : Math.abs(i - leftClosestR[i]);

            if (rightClosestL[i] == leftClosestR[i])
                result.append('.');
            else if (rightClosestL[i] == -1)
                result.append('R');
            else if (leftClosestR[i] == -1)
                result.append('L');
            else if (distLeftR == distRightL)
                result.append('.');
            else
                result.append(distRightL < distLeftR ? 'L' : 'R');
        }

        return result.toString();
    }
}
