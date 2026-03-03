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

    class Pair {
        int maxNode, minNode;
        int sum;

        Pair(int maxNode, int minNode, int sum) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        solve(root);
        return maxSum;
    }

    int maxSum;

    Pair solve(TreeNode root) {
        if (root == null) {
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        

        if (left.maxNode < root.val && root.val < right.minNode) {

            int currSum = left.sum + right.sum + root.val;

            maxSum = Math.max(maxSum , currSum);
            return new Pair(Math.max(root.val, right.maxNode),
                    Math.min(root.val, left.minNode),currSum);
        }
         else{
            return new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
    }
}