class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new Integer[m][n+1][n+1];
        return solve(grid,0,0,n-1);
    }
    Integer[][][] dp;

    int solve(int[][] grid,int i,int j1, int j2){
        if(j1<0 || j2<0 || j1>=grid[0].length || j2>=grid[0].length){
            return 0;
        }


        if(i == grid.length-1){
           if(j1==j2) return grid[i][j1];
           else{
            return grid[i][j1] + grid[i][j2];
           }
        }

        if(dp[i][j1][j2] != null) return dp[i][j1][j2];

        int max = 0;

        for(int idx1 =-1;idx1<=1;idx1++){
            for(int idx2=-1;idx2<=1;idx2++){
                int val = 0;
                if(j1==j2) val = grid[i][j1];
                else val = grid[i][j1] + grid[i][j2];
                max = Math.max(max,val+solve(grid,i+1,j1+idx1,j2+idx2));
            }
        }
        dp[i][j1][j2] = max;

        return dp[i][j1][j2];
    }
}