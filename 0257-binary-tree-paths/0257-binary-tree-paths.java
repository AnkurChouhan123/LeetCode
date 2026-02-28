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
        solve(root, new StringBuilder());
        return list;
    }

    List<String> list;

    void solve(TreeNode root, StringBuilder s) {

        int len = s.length();

        s.append(root.val);

        if (root.left == null && root.right == null) {
            list.add(s.toString());
            // return;
        } else {
            s.append("->");
            if (root.left != null) {
                solve(root.left, s);
            }

            if (root.right != null) {
                solve(root.right, s);
            }

        }

        s.setLength(len);

    }
}