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
    public boolean isBalanced(TreeNode root) {
        valid = true;
        int height = height(root);
        return valid;
    }

    boolean valid;

    int height(TreeNode root) {
        if (valid) {

            if (root == null)
                return 0;
            int left = 1 + height(root.left);
            int right = 1 + height(root.right);
            int diff = Math.abs(left - right);
            if (diff > 1)
                valid = false;

            return Math.max(left,right); 
        }

        return 0;
    }
}