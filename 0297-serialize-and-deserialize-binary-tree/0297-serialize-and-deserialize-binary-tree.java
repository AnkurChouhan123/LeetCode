/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
 
 
    public String serialize(TreeNode root) {

        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        sb.append(root.val+" ");

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0;i<size;i++){
                TreeNode node = q.poll();

                if(node.left!= null ){
                    sb.append(node.left.val + " ");
                    q.add(node.left);
                }
                else{
                    sb.append("n ");
                }
                if(node.right!= null ){
                    q.add(node.right);
                    sb.append(node.right.val + " ");
                }
                else{
                    sb.append("n ");
                }


            }
        }

        System.out.println(sb);

        this.data = sb.toString();

        return sb.toString();


    }

    String data;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        this.data = data;
        

        String[] arr = data.split(" ");
        if(data.isEmpty()) return null;

        Queue<TreeNode> q = new LinkedList<>();

       
        TreeNode ans =new TreeNode(Integer.valueOf(arr[0] + ""));
        q.add(ans);
        int idx = 0;
        int i = 0;
        while(!q.isEmpty()){
            if(arr[i].equals("n") ){
                i++;
                continue;
            }
          TreeNode node = q.poll();
          if(idx*2+1<arr.length &&!arr[idx*2+1].equals("n")){
            node.left = new TreeNode(Integer.valueOf(arr[idx*2+1]+""));
            q.add(node.left);
          }

           if(idx*2+2<arr.length && !arr[idx*2+2].equals("n")){
            node.right = new TreeNode(Integer.valueOf(arr[idx*2+2]+""));
            q.add(node.right);
          }
          i++;
          idx++;
        }

        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));