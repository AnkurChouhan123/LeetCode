class Solution {
    int mod = (int)(1e9+7);
    public int checkRecord(int n) {

        dp = new Integer[n+1][2][3];
      return solve(n,0,0);
    }

    Integer[][][]dp;

    int solve(int n, int A, int L) {

        if(n == 0) return 1;
        
        if(dp[n][A][L] != null) return dp[n][A][L];
        
        int ans = 0;
        if (A == 1 && L == 2) {
            ans = (ans + solve(n - 1, A , 0)) % mod;
        } else if (A == 1) {
            ans = (ans + solve(n - 1 , A , 0)) % mod;
            ans = (ans + solve(n - 1, A , L+1)) % mod;
        } else if (L == 2) {
            ans = (ans + solve(n - 1, A , 0)) % mod;
            ans = (ans + solve(n - 1, A + 1, 0)) % mod;
        } else {
            ans = (ans + solve(n - 1, A, 0)) % mod;
            ans = (ans + solve(n - 1, A + 1, 0)) % mod;
            ans = (ans + solve(n - 1, A, L+1)) % mod;
        }

        dp[n][A][L] = ans % mod;
        return dp[n][A][L];
    }
}