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
    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return solve(preorder,Integer.MAX_VALUE);
    }

    int i;

    TreeNode solve(int[] preorder,int bound){
        if(i == preorder.length || preorder[i] > bound) return null;
        TreeNode root = new TreeNode(preorder[i++]);

        root.left = solve(preorder,root.val);
        root.right = solve(preorder,bound);

        return root;
    }
}