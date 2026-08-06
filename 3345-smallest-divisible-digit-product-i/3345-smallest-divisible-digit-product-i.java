class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int num = n;
            int product = 1;
        
            // product of digits
            while(num > 0){
                int dig = num % 10;
                product *= dig;
                num /= 10;
                
            }
            // check for divisible 
            if(product % t ==0) 
                return n;

                n++;

            
        }    
        
    }
}