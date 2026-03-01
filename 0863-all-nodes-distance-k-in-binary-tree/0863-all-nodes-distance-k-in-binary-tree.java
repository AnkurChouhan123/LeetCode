/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        parent = new HashMap<>();
        addParents(root);
        // HashMap<TreeNode,Boolean> visited = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(target,0));
        visited.add(target);

        // System.out.println(parent);

        while(!q.isEmpty()){
            Pair p  = q.poll();
            TreeNode node = p.node;
            int idx = p.idx;

            if(idx == k) list.add(node.val);

            if(idx<k){

                if(node.left!=null && !visited.contains(node.left)){
                   q.add(new Pair(node.left,idx+1));
                   visited.add(node.left);
                }

                if(node.right!=null && !visited.contains(node.right)){
                   q.add(new Pair(node.right,idx+1));
                   visited.add(node.right);
                }
                
                if(parent.containsKey(node) && !visited.contains(parent.get(node))){
                    q.add(new Pair(parent.get(node),idx+1));
                    visited.add(parent.get(node));
                }
            }
        }

       return list;
    }

    HashMap<TreeNode , TreeNode> parent;

    void addParents(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left!=null){
                parent.put(node.left, node);
                q.add(node.left);
            }

            if(node.right!=null){
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
    }
}