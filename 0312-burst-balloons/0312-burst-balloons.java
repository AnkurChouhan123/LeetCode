class Solution {
    public int maxCoins(int[] nums) {

        int m = nums.length;

        int[] arr = new int[m+2];

        dp = new Integer[m+2][m+2];

        Arrays.fill(arr,1);

        for(int i = 0;i<m ;i ++){
            arr[i + 1] = nums[i];
        }

        return solve(arr,1,m);
    }

    Integer[][] dp;


    int solve(int[] arr, int i,int j){

        if(i > j) return 0;

        if(dp[i][j] != null) return dp[i][j];

        int max = Integer.MIN_VALUE;

        for(int k = i;k<=j;k++){
            int cost = arr[i-1] * arr[k] * arr[j+1]
                      + solve(arr,i,k-1) + solve(arr,k+1,j);

            max = Math.max(max,cost);
        }

        dp[i][j] = max;

        return dp[i][j];
    }
}