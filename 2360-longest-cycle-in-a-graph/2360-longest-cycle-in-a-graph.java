class Solution {
    public int longestCycle(int[] edges) {
        boolean[] vis = new boolean[edges.length];
        int ans = -1;

        for(int i = 0; i < edges.length; i++){
            if(!vis[i]){
                ans = Math.max(ans, findCycle(edges, i, vis));
            }
        }

        return ans;
    }

    int findCycle(int[] edges, int start, boolean[] vis){
        HashMap<Integer, Integer> map = new HashMap<>();

        int node = start;
        int step = 0;

        while(node != -1){
            if(map.containsKey(node)){
                return step - map.get(node);
            }

            if(vis[node]) return -1;

            vis[node] = true;
            map.put(node, step);

            step++;
            node = edges[node];
        }

        return -1;
    }
}