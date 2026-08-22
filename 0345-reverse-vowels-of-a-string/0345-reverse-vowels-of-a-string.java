class Solution {

    public boolean isVowel(char ch){
        
        return  ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
             ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
            

        
    }
    public String reverseVowels(String str) {
        char [] s = str.toCharArray();


        int i = 0;
        int j = s.length-1;

        while( i < j){
            if(!isVowel(s[i])){
                i++;
            }else if(!isVowel(s[j])){
                j--;
            }else{
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
            }
        }

        return new String(s);
        
    }
}