class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        dp = new Integer[triangle.size()+1][triangle.size()+1];
        return triangle.get(0).get(0) +  solve(triangle,1,0);
    }

    Integer[][] dp;

    int solve(List<List<Integer>> triangle , int i, int idx){

        if(i>=triangle.size()) return 0;
        if(idx>=triangle.get(i).size()) return 0;

        if(dp[i][idx] != null) return dp[i][idx];
        int same =  triangle.get(i).get(idx) + solve(triangle,i+1,idx);
        int next = triangle.get(i).get(idx+1) + solve(triangle,i+1,idx+1);

        dp[i][idx] =  Math.min(same,next);

        return dp[i][idx];
    }

}