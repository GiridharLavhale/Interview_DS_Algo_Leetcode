//T.C : Lines
//S.C : constant
public class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0;
        
        for (char ch : t.toCharArray())
            sum += ch;
        
        for (char ch : s.toCharArray())
            sum -= ch;
        
        return (char) sum;
    }
}

