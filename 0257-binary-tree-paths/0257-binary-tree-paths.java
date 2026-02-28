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
    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        solve(root, "");
        return list;
    }

    List<String> list;

    void solve(TreeNode root, String s) {

        if (root.left == null && root.right == null) {
            s = s + root.val;
            list.add(s);
            return;
        }
        if (root.left != null) {
            solve(root.left, s + root.val + "->");
        }

        if (root.right != null) {
            solve(root.right, s + root.val + "->");
        }

    }
}