class Solution {
    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return solve(s,t,0,0);
    }

    Integer[][] dp;

    int solve(String s,  String t, int i, int j){

        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(dp[i][j] != null) return dp[i][j];
        
        int firstWay = solve(s,t,i+1,j);

        int secondWay = 0;

        if(s.charAt(i) == t.charAt(j)){
            secondWay = solve(s,t,i+1,j+1); 
        }

        dp[i][j] = firstWay + secondWay;
        return dp[i][j];
    }
}


// if both matched either i or either j or both 
// if not matched then increase i