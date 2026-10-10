class Solution {
    /*
    Checks if all cows can be placed while keeping
    at least distance gap between every pair.
    */
    private boolean canPlace(int[] position, int m, int mindistance) {
        // The first cow is placed at the first stall
        // to leave maximum room for the remaining cows.
        int cowsPlaced = 1;
 
        // This stores the position of the most recently placed cow.
        int lastPosition = position[0];
 
        for (int i = 1; i < position.length; i++) {
            // Place a cow only when this stall is far enough
            // from the last chosen stall.
            if (position[i] - lastPosition >= mindistance) {
                cowsPlaced++;
                lastPosition = position[i];
 
                // Once all cows are placed, this distance is possible.
                if (cowsPlaced >= m) {
                    return true;
                }
            }
        }
 
        return false;
    }
    /*
    Returns the largest minimum distance by
    checking every possible distance one by one.
    */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1, high = position[n-1] - position[0];

        while(low <= high){
            int mid = low + (high- low) / 2;
            if( canPlace(position, m, mid) == true){
                low = mid + 1;

            }else{
                high = mid - 1; 
            }
        }
        return high;
 
    }
}

        
    