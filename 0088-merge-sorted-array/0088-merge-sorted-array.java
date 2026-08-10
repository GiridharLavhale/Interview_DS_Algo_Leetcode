// import java.util.Arrays;
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int left = m-1;
//         int right = 0;

//         while(left >= 0 && right < n){
//             if(nums1[left] > nums2[right]){

//                 int temp = nums1[left];
//                 nums1[left] = nums2[right];
//                 nums2[right] = temp;
                
//                 left--;
//                 right++;
//             }else{
//                 break;
//             }
//         } 
//         Arrays.sort(nums1, 0, m);
//         Arrays.sort(nums2, 0, n);
        
//     }
// }

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {

            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }
    }
}