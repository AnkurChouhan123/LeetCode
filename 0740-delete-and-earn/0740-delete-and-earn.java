class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        dp = new Integer[max+1];
        int[] freq = new int[max+1];
        for(int num : nums){

            freq[num] += num;
        }

        return solve(freq,0);
    }

    Integer[] dp;

    int solve(int[] freq,int i){
         
         if(i >= freq.length) return 0;

         if(dp[i] != null) return dp[i];

         int notTake = solve(freq,i+1);
         int take = freq[i] + solve(freq,i+2);

         dp[i] = Math.max(take,notTake);

         return dp[i];
    }
}