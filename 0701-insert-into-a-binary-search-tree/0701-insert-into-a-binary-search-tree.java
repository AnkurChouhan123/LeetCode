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
    public TreeNode insertIntoBST(TreeNode root, int key) {
        TreeNode curr = root;

        if(root == null) return new TreeNode(key);

        while (curr != null) {
            if (curr.val > key) {
                if (curr.left == null) {
                    curr.left = new TreeNode(key);
                    return root;
                } else {
                    curr = curr.left;
                }
            }

            if (curr.val < key) {
                if (curr.right == null) {
                    curr.right = new TreeNode(key);
                    return root;
                } else {
                    curr = curr.right;
                }
            }
        }

        return null;
    }
}