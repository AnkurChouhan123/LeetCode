class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        this.arr = arr;
        // this.n = n;
        this.k = k;

        dp = new Integer[n];

        return solve(0);
    }
    Integer[] dp;

    int[] arr;
    int n;
    int k;

    int solve(int i){

        if(i == n) return 0;

        if(dp[i] != null) return dp[i];


        int maxAns = 0;
        int max = -1;
        int len = 0;
        for(int j = i;j<Math.min(n,i+k);j++){
          len++;
          max = Math.max(max,arr[j]);
          int sum = max*len + solve(j+1);

          maxAns = Math.max(maxAns,sum);

        }

        return dp[i] = maxAns;
    }
}