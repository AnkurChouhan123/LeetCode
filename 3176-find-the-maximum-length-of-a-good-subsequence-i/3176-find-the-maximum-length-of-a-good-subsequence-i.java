class Solution {
    public int maximumLength(int[] nums, int k) {
        
     dp = new Integer[nums.length+1][nums.length+1][k+1];
        return solve(nums, 0, -1 , k);
    }

    Integer[][][] dp;

    int solve(int[] nums,int i,int prev,int k){
        
        // if( k == -1) return 0;
        if( i == nums.length) return 0;

        if(dp[i][prev+1][k] != null) return dp[i][prev+1][k];
        
        int notTake = solve(nums,i+1,prev,k);

        int take = 0;
        
        if(prev == -1 || nums[i] == nums[prev] ){
            take = 1 + solve(nums,i+1,i,k);
        }
        // else if(prev == (int) 1e9 ) take = 1 + solve(nums,i+1,nums[i],k);
        else if(k>0)  take = 1 + solve(nums,i+1,i,k-1);
        

         dp[i][prev+1][k] = Math.max(notTake,take);
         return  dp[i][prev+1][k];
    }
}