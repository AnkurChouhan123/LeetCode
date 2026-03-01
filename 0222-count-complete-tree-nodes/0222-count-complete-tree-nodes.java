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
    public int countNodes(TreeNode root) {
        return solve(root)/2;
    }

    int solve(TreeNode root){
        if(root == null) return 0;

        int left = 1 + solve(root.left);
        int right = 1+  solve(root.right);
          
          return left + right;

    }


}