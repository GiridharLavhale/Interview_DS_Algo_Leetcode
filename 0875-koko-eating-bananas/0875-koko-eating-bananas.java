class Solution {
    int FindMax(int[] piles){  // Find the max element in the piles 
        int Maxi = Integer.MIN_VALUE;
        int n = piles.length;
        for(int i = 0; i < n; i++){
            Maxi = Math.max(Maxi, piles[i]);
        }
        return Maxi;
    }

    int CalculateTotalHours(int[] piles, int hourly){  //Calaculating the hours for eating the bananas
        int TotalH = 0;
        int n = piles.length;
        for(int i = 0; i < n; i++){
            TotalH += Math.ceil((double)piles[i] / (double)hourly);
        }

        return TotalH;
    }
    public int minEatingSpeed(int[] piles, int h) {  // comparing TotalH <=h for taking min element 
        int low = 1;
        int high = FindMax(piles);
        while(low <= high){
            int mid = low + (high - low) / 2;
            int TotalH = CalculateTotalHours(piles, mid);
            if(TotalH <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;

        
    }
}