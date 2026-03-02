class Solution {
    
    int mod = (int)(1e9 + 7);

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        dp = new Integer[m+1][n+1][maxMove + 1];
        this.m = m;
        this.n = n;

        return solve(startRow,startColumn,maxMove);


    }

    int m;
    int n;

    Integer[][][] dp;

    int solve(int i ,int j, int moves){

     if(i<0 || j<0 || i == m || j == n) return 1;
     if(moves == 0) return 0;

     if(dp[i][j][moves] != null) return dp[i][j][moves];

     long up = solve(i-1,j,moves-1);
     long down = solve(i+1,j,moves-1);
     long right = solve(i,j+1,moves-1);
     long left = solve(i,j-1,moves-1);

     dp[i][j][moves] = (int)((up + down + right + left) % mod );

     return dp[i][j][moves];

    }
}