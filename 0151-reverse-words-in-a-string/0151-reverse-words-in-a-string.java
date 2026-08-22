class Solution { 
 
    public String reverseWords(String s) { 
 
        char[] arr = s.toCharArray(); 
 
        reverse(arr, 0, arr.length - 1); 
 
        int i = 0; 
        int l = 0, r = 0; 
        int n = arr.length; 
 
        while (i < n) { 
 
            while (i < n && arr[i] != ' ') { 
                arr[r++] = arr[i++]; 
            } 
 
            if (l < r) { 
                reverse(arr, l, r - 1); 
 
                // Add space only if there are more words
                if (i < n) { 
                    arr[r++] = ' '; 
                } 
 
                l = r; 
            } 
 
            // Skip all spaces
            while (i < n && arr[i] == ' ') { 
                i++; 
            } 
        } 
 
        // Remove the last extra space
        if (r > 0 && arr[r - 1] == ' ') { 
            r--; 
        } 
 
        return new String(arr, 0, r); 
    } 
 
    private void reverse(char[] arr, int left, int right) { 
 
        while (left < right) { 
            char temp = arr[left]; 
            arr[left] = arr[right]; 
            arr[right] = temp; 
 
            left++; 
            right--; 
        } 
    } 
}