class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // [2,3,3,5]
        // two pointer approach
        int i = 0;
        int j = people.length - 1;

        
        int boats = 0;
        
        while(i <= j){
            if(people[i] + people[j] <= limit){
              
             i++;
            }
            j--;
            boats++;
        }   

        return boats; 
    }
}