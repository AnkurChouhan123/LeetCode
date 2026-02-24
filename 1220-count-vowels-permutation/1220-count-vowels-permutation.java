class Solution {
    public int countVowelPermutation(int n) {
    dp = new Integer[n+1][7];
      return solve(n,-1);
    }

    int mod = (int)(1e9+7);
    Integer[][] dp;

    int solve(int n, int last) {

        if(n == 0) return 1;

        if(dp[n][last+1] != null) return dp[n][last+1];

        int result = 0;
        if (last == -1) {
            for (int i = 1; i <= 5; i++) {
                result = (result + solve(n - 1, i)) % mod;
            }
        }

        else{
            if(last == 1){
                result = (result + solve(n - 1, 2)) % mod;
            }
            else if(last == 2){
                result = (result + solve(n - 1, 1)) % mod;
                result = (result + solve(n - 1, 3)) % mod;
            }
            else if(last == 3){
                result = (result + solve(n - 1, 1)) % mod;
                result = (result + solve(n - 1, 2)) % mod;
                result = (result + solve(n - 1, 4)) % mod;
                result = (result + solve(n - 1, 5)) % mod;
            }
            else if(last == 4){
                result = (result + solve(n - 1, 3)) % mod;
                result = (result + solve(n - 1, 5)) % mod;
            }
            else if(last == 5){
                result = (result + solve(n - 1, 1)) % mod;
            }
        }

        dp[n][last+1] = result;
        return dp[n][last+1];
    }
}

// LAST --- >
// 1 -> a 
// 2 -> e
// 3 -> i 
// 4 -> o 
// 5 -> u <------