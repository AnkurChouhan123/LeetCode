class Solution {
    public int minSteps(int n) {
        dp = new Integer[n+1][n+1];
        // for(int[] a : dp) Arrays.fill(a,-1);
        if (n == 1)
            return 0;
        return solve(n, 0, 1);
    }

    Integer[][] dp;

    int solve(int n, int available, int onScreen) {

        if (onScreen == n)
            return 0;
            if(onScreen > n) return (int)1e7;

            if(dp[available][onScreen] != null) return dp[available][onScreen];

        int paste = (int) 1e7;
        if (available > 0) {
            paste = 1 + solve(n, available, onScreen + available);
        }
        int copy = (int) 1e7;
            if(available!=onScreen)
             copy = 1 + solve(n, onScreen, onScreen);
        

        dp[available][onScreen] = Math.min(copy, paste);
        return dp[available][onScreen];
    }
}