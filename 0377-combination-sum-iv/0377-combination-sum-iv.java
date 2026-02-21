class Solution {
    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[nums.length][target+1];
        return solve(nums,0,target);
    }

    Integer[][] dp;

    int solve(int[] nums,int i,int target){

    if(target == 0) return 1;
    if(dp[i][target] != null) return dp[i][target];
      int ans = 0;
      for(int idx = 0;idx < nums.length;idx++){
        if(nums[idx] <= target){
            ans += solve(nums,idx,target-nums[idx]);
        }
      }

      dp[i][target] = ans;
      return dp[i][target];
      
    }
}