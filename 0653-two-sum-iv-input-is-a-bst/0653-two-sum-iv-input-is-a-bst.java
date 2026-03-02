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
    public boolean findTarget(TreeNode root, int k) {

        set = new HashSet<>();

        return solve(root,k);
    }

    Set<Integer> set;

    boolean solve(TreeNode root , int k){

        if(root == null) return false;
        
        int need = k - root.val;

        if(set.contains(need)) return true;

        set.add(root.val);

        if(solve(root.left,k)) return true;
        if(solve(root.right,k)) return true;

        return false;
    }
}