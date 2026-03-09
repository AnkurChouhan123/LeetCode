class Solution {
    public int getMoneyAmount(int n) {

        dp = new Integer[n+1][n+1];
        return solve(n,1,n);
    }

    Integer[][] dp;

    int solve(int n,int i, int j){

        if(i>=j) return 0;

        if(dp[i][j] != null) return dp[i][j];

       int ans = (int)1e7;
       for(int idx = i;idx<=j;idx++){
          int cost = idx + Math.max(solve(n,i,idx-1) , solve(n,idx+1,j));


          ans = Math.min(ans,cost);
       }

       return  dp[i][j] = ans;

    }
}
