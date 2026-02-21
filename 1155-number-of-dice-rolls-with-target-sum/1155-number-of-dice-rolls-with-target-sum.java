class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][target+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return solve(n,k,target);
    }
    int mod = (int)(1e9+7);
    
    int[][] dp;

    int solve(int n,int k,int target){

    if( n==0 && target == 0 ) return 1;
    if(n == 0) return 0;

    if(dp[n][target] != -1) return dp[n][target];

      long result = 0;
      for(int i = 1;i<=k;i++){
        
        if(i<=target){
           result = (result + solve(n-1,k,target-i))%mod;
        }
      }

      dp[n][target] = (int)(result % mod);
      return dp[n][target];
    }
}