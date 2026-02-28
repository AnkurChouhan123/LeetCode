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
        int level;
        int state;

        Pair(TreeNode node, int level, int state){
            this.node = node;
            this.level = level;
            this.state = state;
        }

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer,List<int[]>> map = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0,0));

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                Pair  p = q.poll();
                TreeNode node = p.node;
                int state = p.state;
                int level = p.level;
                if(map.containsKey(state)){
                    List<int[]>list = map.get(state);
                    list.add(new int[]{node.val,level});
                    map.put(state,list);
                }
                else{
                    List<int[]>list = new ArrayList<>();
                    list.add(new int[]{node.val,level});
                    map.put(state,list);
                }
                if(node.left!=null){
                    q.add(new Pair(node.left,level+1,state-1));
                }

                if(node.right!=null){
                    q.add(new Pair(node.right,level+1,state+1));
                }
            }
        }

        for(int key:map.keySet()){
            List<int[]> list = map.get(key);
            Collections.sort(list,(a,b)->{
                if(a[1] == b[1]){
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<list.size();i++){
                temp.add(list.get(i)[0]);
            }

            ans.add(temp);
        }
        return ans;

    }
}