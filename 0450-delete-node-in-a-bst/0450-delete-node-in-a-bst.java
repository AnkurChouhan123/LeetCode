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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null && root.right == null) return null;
            if(root.left == null){
                return root.right;
            }
            if(root.right == null) return root.left;

            TreeNode temp = root.right;
            root = root.left;
            TreeNode curr = root;
            while(curr.right != null){
                curr = curr.right;
            }
            curr.right = temp;
            return root;
        }

        TreeNode curr = root;

        while (curr != null) {
            if (key < curr.val) {
                if (curr.left == null)
                    return root;
                else if (curr.left.val == key) {
                    if (curr.left.left == null) {
                        curr.left = curr.left.right;
                        return root;
                    }
                    else if(curr.left.right == null){
                        curr.left = curr.left.left;
                        return root;
                    }
                    else{
                        TreeNode temp = curr.left.right;

                        curr.left = curr.left.left;

                        curr = curr.left;
                        while(curr.right != null){
                            curr = curr.right;
                        }

                        curr.right = temp;

                        return root;
                    }
                    

                }
                else{
                    curr = curr.left;
                }
            }

            else if (key > curr.val) {
                if (curr.right == null)
                    return root;
                else if (curr.right.val == key) {
                    if (curr.right.right == null) {
                        curr.right = curr.right.left;
                        return root;
                    }
                    else if(curr.right.left == null){
                        curr.right = curr.right.right;
                        return root;
                    }
                    else{
                        TreeNode temp = curr.right.left;

                        curr.right = curr.right.right;

                        curr = curr.right;
                        while(curr.left != null){
                            curr = curr.left;
                        }

                        curr.left = temp;

                        return root;
                    }
                    

                }
                else{
                    curr = curr.right;
                }
            }
        }

        return root;

    }
}