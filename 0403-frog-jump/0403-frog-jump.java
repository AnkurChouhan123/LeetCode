class Solution {
    public boolean canCross(int[] stones) {
        dp = new Boolean[stones.length][stones.length+1];
        if(stones[1] != 1) return false;
        return solve(stones,1,1);
    }

    Boolean[][] dp;

    boolean solve(int[] stones, int i, int k) {
        if(k<=0) return false;
        if(i==stones.length-1) return true;

        if(dp[i][k] != null) return dp[i][k];

        for (int idx = i+1; idx < stones.length; idx++) {

            int jump = stones[idx] - stones[i];

            if(jump>k+1) break;

            if (jump == k || jump == k-1 || jump == k+1) {
                if(solve(stones, idx, stones[idx] - stones[i])){
                    dp[i][k] = true;
                    return dp[i][k];
                }
            }
           
        }

        dp[i][k] =  false;
        return dp[i][k];

    }
}