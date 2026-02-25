class Solution {
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return solve(s,p,0,0);
    }

    Boolean[][] dp;

    boolean solve(String s,String p, int i,int j){
        
        if(j == p.length()) return i == s.length();

        if(dp[i][j] != null) return dp[i][j];

        boolean matched = false;

        if(i<s.length()){
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                matched = true;
            }
        }
        
        if(j+1<p.length() && p.charAt(j+1) == '*'){
           dp[i][j] = solve(s,p,i,j+2) || matched && solve(s,p,i+1,j);
           return dp[i][j];
        }
        
            dp[i][j] = matched && solve(s,p,i+1,j+1);
            return dp[i][j];
        
    }
}