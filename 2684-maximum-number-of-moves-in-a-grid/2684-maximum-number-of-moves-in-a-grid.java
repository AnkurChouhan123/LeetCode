class Solution {
    public int maxMoves(int[][] grid) {
        dp = new Integer[grid.length][grid[0].length];
        int max = 0;
        for(int i = 0;i<grid.length;i++){
            max = Math.max(max,solve(grid,i,0));
        }

        return max;
    }

    Integer[][] dp;

    int solve(int[][] grid,int i,int j){
    //    if(i<0 || j<0 || i == grid.length || j == grid[0].length) return 0;

    if(dp[i][j] != null) return dp[i][j];
       int firstWay = 0;
       int secondWay = 0;
       int thirdWay = 0;
        if(i-1 >= 0 && j+1 < grid[0].length && grid[i-1][j+1] > grid[i][j]){
           firstWay = 1 + solve(grid,i-1,j+1);
        }

        if( j+1 < grid[0].length && grid[i][j+1] > grid[i][j]){
           secondWay = 1 + solve(grid,i,j+1);
        }

        if(i+1 < grid.length && j+1 < grid[0].length && grid[i+1][j+1] > grid[i][j]){
           thirdWay = 1 + solve(grid,i+1,j+1);
        }

        dp[i][j] = Math.max(firstWay, Math.max(secondWay,thirdWay));
        return dp[i][j];
    }

    // boolean isSafe(int[][] grid,int i,int j){
       
    // }
}