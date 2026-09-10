/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int result;

    private Pair<Integer, Integer> solve(TreeNode root){
        if(root == null){
            return new Pair<>(0,0);
        }

        Pair<Integer, Integer> left = solve(root.left);
        Pair<Integer, Integer> right = solve(root.right);

        int leftsum = left.getKey();
        int leftcount = left.getValue();

        int rightsum = right.getKey();
        int rightcount = right.getValue();

        int Sum = leftsum + rightsum + root.val;
        int Count = leftcount + rightcount + 1;

        int Avg = (Sum/Count);

        if(Avg == root.val){
            result += 1;
        }

        return new Pair<>(Sum, Count);


    }
    public int averageOfSubtree(TreeNode root) {
        result = 0;

        solve(root);

        return result;
        
    }
}