class Solution {
    int mod = (int)(1e9 + 7);
    Integer[][] dp;

    public int knightDialer(int n) {

        dp = new Integer[10][n+1];

        long total = 0;

        for(int i = 0 ; i < 10; i++){
            total = (total + solve(i,n)) % mod;
        }

        return (int) total;
    }

    int solve(int i, int n) {

        if (n == 1)
            return 1;

        if (dp[i][n] != null)
            return dp[i][n];

        long ans = 0;

        if (i == 1) {
            ans = (ans + solve(6, n - 1)) % mod;
            ans = (ans + solve(8, n - 1)) % mod;
        }
        else if (i == 2) {
            ans = (ans + solve(7, n - 1)) % mod;
            ans = (ans + solve(9, n - 1)) % mod;
        }
        else if (i == 3) {
            ans = (ans + solve(4, n - 1)) % mod;
            ans = (ans + solve(8, n - 1)) % mod;
        }
        else if (i == 4) {
            ans = (ans + solve(3, n - 1)) % mod;
            ans = (ans + solve(9, n - 1)) % mod;
            ans = (ans + solve(0, n - 1)) % mod;
        }
        else if (i == 5) {
            return 0;
        }
        else if (i == 6) {
            ans = (ans + solve(1, n - 1)) % mod;
            ans = (ans + solve(7, n - 1)) % mod;
            ans = (ans + solve(0, n - 1)) % mod;
        }
        else if (i == 7) {
            ans = (ans + solve(6, n - 1)) % mod;
            ans = (ans + solve(2, n - 1)) % mod;
        }
        else if (i == 8) {
            ans = (ans + solve(1, n - 1)) % mod;
            ans = (ans + solve(3, n - 1)) % mod;
        }
        else if (i == 9) {
            ans = (ans + solve(4, n - 1)) % mod;
            ans = (ans + solve(2, n - 1)) % mod;
        }
        else if (i == 0) {
            ans = (ans + solve(4, n - 1)) % mod;
            ans = (ans + solve(6, n - 1)) % mod;
        }

        dp[i][n] = (int) ans;
        return dp[i][n];
    }
}