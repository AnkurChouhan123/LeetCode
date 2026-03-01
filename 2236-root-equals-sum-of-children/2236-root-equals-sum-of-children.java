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
    public boolean checkTree(TreeNode root) {

       Queue<TreeNode> q = new LinkedList<>();

       q.add(root);

       while(!q.isEmpty()){
        TreeNode node = q.poll();

        if(node.left == null && node.right == null) continue;

        int num1 = 0;
        int num2 = 0;
        
        if(node.left!=null) {
            num1 = node.left.val;
            q.add(node.left);
        }
        if(node.right!=null){
           num2 = node.right.val;
           q.add(node.left);
        }

        if(num1 + num2 != node.val) return false;
        
       }

       return true;
    }
}