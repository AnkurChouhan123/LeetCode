class Solution {
    public int findRotateSteps(String ring, String key) {
        map = new HashMap<>();
        dp = new Integer[ring.length()][key.length()];

        for(int i = 0;i<ring.length();i++){
            char ch = ring.charAt(i);
            if(map.containsKey(ch)){
                ArrayList<Integer> temp = map.get(ch);
                temp.add(i);
                map.put(ch,temp);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(ch,temp);
            }
        }

        return solve(ring,key,0,0);
    }
    Integer[][] dp;

    HashMap<Character,ArrayList<Integer>> map;

    int solve(String ring,String key,int i,int j){

        int n = ring.length();

        if(j == key.length()) return 0;

        if(dp[i][j] != null) return dp[i][j];
       
       ArrayList<Integer> tempList = map.get(key.charAt(j));

       int forward = (int)1e9;
       for(int idx : tempList){
        int rotate = (idx-i+n )%n;
        int total =  1 + rotate + solve(ring,key,idx,j+1);
        forward = Math.min(forward,total);
       }

       int backward = (int)1e9;
       for(int idx : tempList){
        int rotate = (i-idx+n) % n;
        int total =  1 + rotate + solve(ring,key,idx,j+1);
        backward = Math.min(backward,total);
       }

       dp[i][j] = Math.min(forward,backward);

       return dp[i][j];


    }
}