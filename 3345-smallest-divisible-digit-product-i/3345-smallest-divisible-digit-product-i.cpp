class Solution {
public:
    int FindDigitprod( int num){
        int prod = 1;
        while( num) {
            prod = prod*(num%10);
            if(prod == 0)
                return 0;
            
            num /=10;
        }
        return prod;

    }
    int smallestNumber(int n, int t) {
        for( int num = n; num <= n+10; num++){
            if(FindDigitprod(num) % t == 0){
                return num;
            }    
        }

        return -1;
        
    }
};