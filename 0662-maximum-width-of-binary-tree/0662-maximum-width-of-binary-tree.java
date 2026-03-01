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

    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
      Deque<Pair> q = new ArrayDeque<>();
      int max = 0;

      q.add(new Pair(root,1));

      while(!q.isEmpty()){
        int firstIdx = q.getFirst().idx;
        int lastIdx = q.getLast().idx;

        max = Math.max(max,lastIdx - firstIdx + 1);

        int size = q.size();

        for(int i = 0;i<size;i++){
            Pair p = q.pollFirst();
            TreeNode node = p.node;
            int idx = p.idx;

            if(node.left != null) q.add(new Pair(node.left, idx * 2));
            if(node.right != null) q.add(new Pair(node.right, idx * 2 + 1));
        }
      }

      return max;

    }
}

// just added index to every node by level order see below->

//         1
//      2      3    -> width = 3 - 2 + 1 = 2
//    4   5  6   7  -> width = 7 - 4 + 1 = 4