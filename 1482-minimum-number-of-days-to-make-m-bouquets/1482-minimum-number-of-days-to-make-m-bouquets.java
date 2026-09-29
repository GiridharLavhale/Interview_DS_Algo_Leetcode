import java.util.*;

class Solution {
    /*
    Checks if at least m bouquets can be made
    by the given day using adjacent flowers.
    */
    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        // This counts bloomed flowers that are adjacent so far.
        int consecutive = 0;

        // This counts how many complete bouquets are already formed.
        int bouquets = 0;

        for (int bloom : bloomDay) {
            // This flower can be used because it has bloomed by the chosen day.
            if (bloom <= day) {
                consecutive++;

                // k adjacent bloomed flowers complete one bouquet.
                if (consecutive == k) {
                    bouquets++;

                    // Reset because these flowers are already used
                    // in the bouquet that was just made.
                    consecutive = 0;
                }
            } else {
                // An unbloomed flower breaks the adjacent group,
                // so the current consecutive count must restart.
                consecutive = 0;
            }
        }

        // The chosen day works only if enough bouquets were formed.
        return bouquets >= m;
    }

    /*
    Returns the minimum day needed to make
    m bouquets using binary search on days.
    */
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        // If total required flowers are more than available flowers,
        // making all bouquets is impossible.
        if ((long)m * k > n) {
            return -1;
        }

        // The answer cannot be smaller than the earliest bloom day.
        int low = bloomDay[0];

        // The answer never needs to go beyond the latest bloom day.
        int high = bloomDay[0];

        for (int bloom : bloomDay) {
            low = Math.min(low, bloom);
            high = Math.max(high, bloom);
        }

        // This stores the best working day found so far.
        int answer = -1;

        while (low <= high) {
            // mid is the day currently being tested.
            int mid = low + (high - low) / 2;

            // If mid works, save it and search for a smaller valid day.
            if (canMakeBouquets(bloomDay, mid, m, k)) {
                answer = mid;
                high = mid - 1;
            } else {
                // If mid does not work, earlier days cannot work either.
                low = mid + 1;
            }
        }

        return answer;
    }
}

// public class Main {
//     // Driver code starts
//     public static void main(String[] args) {
//         int[] bloomDay = {1, 10, 3, 10, 2};
//         int m = 3;
//         int k = 1;

//         Solution obj = new Solution();
//         System.out.println(obj.minDays(bloomDay, m, k));
//     }
// }