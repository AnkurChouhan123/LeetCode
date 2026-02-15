class Solution {
    public int rob(int[] nums) {
        dp = new Integer[nums.length+1];
        return solve(nums,0);
    }

    Integer[] dp;

    int solve(int[] nums , int i){
        if(i>=nums.length) return 0;

        if(dp[i] != null) return dp[i];

        int notRob = solve(nums,i+1);
        int rob = nums[i] + solve(nums,i+2);

        dp[i] = Math.max(notRob,rob);
        return dp[i];
    }
}