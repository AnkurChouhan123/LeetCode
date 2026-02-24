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
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        solve(root, "");

        return sum;
    }

    int sum;

    void solve(TreeNode root, String s) {
        if (root == null) {
            return;
        }

        s = s + root.val;

        if(root.left == null && root.right == null){
            sum += Integer.parseInt(s,2);
            return;
        }

        solve(root.left, s);
        solve(root.right, s);
    }

}