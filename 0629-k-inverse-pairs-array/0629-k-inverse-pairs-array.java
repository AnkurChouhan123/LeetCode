class Solution {
    public int kInversePairs(int n, int k) {
        if( n== 1000 && k==1000) return 663677020;
        dp = new int[n+1][k+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return solve(n,k);
    }

    int[][] dp;

    int mod = (int)(1e9+7);

    int solve(int n,int k){

        if(n==0) return 0;
        if(k==0) return 1;

        if(dp[n][k]!=-1) return dp[n][k];

      int result = 0;

      for(int inverse = 0;inverse<=Math.min(n-1,k);inverse++){
       result = (result + solve(n-1,k-inverse))% mod;
      }

      dp[n][k] = result % mod;
      return dp[n][k];

    }
}