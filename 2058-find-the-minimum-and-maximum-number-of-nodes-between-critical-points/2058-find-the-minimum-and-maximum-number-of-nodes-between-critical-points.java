/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        int i = 1;
        int prevcriticalpos = 0;
        int firstcriticalpos = 0;

        int minDist = Integer.MAX_VALUE;

        while( curr.next != null){
            if(curr.val < prev.val && curr.val < curr.next.val ||
                curr.val > prev.val && curr.val > curr.next.val){

                    if(prevcriticalpos == 0){
                        prevcriticalpos = i;
                        firstcriticalpos = i;

                    }else{
                        minDist = Math.min(minDist, i - prevcriticalpos );
                        prevcriticalpos = i;
                    }

            }

            i++;
            prev = curr;
            curr = curr.next;
        }
        if(minDist == Integer.MAX_VALUE){
            return new int[] {-1,-1};
        }

        return new int[] {minDist,prevcriticalpos - firstcriticalpos };
    }
}