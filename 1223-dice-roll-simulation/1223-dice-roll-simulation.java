class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        dp = new int[n+1][7][17];
        for(int i = 0;i<=n; i++){
            for(int j = 0;j<7;j++){
                for(int k = 0;k<17;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(n,-1,rollMax,0);
    }

    int[][][] dp;

    int mod = (int)(1e9+7);

    int solve(int n,int prevFace, int[] roll,int count){
        if( n==0 ) return 1;
        if(dp[n][prevFace+1][count] != -1) return dp[n][prevFace+1][count];
        int result = 0;
        for(int face = 0; face<6; face++){
            if(face == prevFace){
                if(roll[face] > count){
                    result = (result + solve(n-1,face,roll,count+1)) % mod;
                }
            }
            
            else{
                result =(result + solve(n-1,face,roll,1)) % mod;
            }
        }
        dp[n][prevFace+1][count] = result;
        return dp[n][prevFace+1][count];
    }
}