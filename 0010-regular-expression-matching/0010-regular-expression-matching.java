class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s,p,0,0);
    }

    boolean solve(String s,String p, int i,int j){
        
        if(j == p.length()) return i == s.length();

        boolean matched = false;

        if(i<s.length()){
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                matched = true;
            }
        }
        
        if(j+1<p.length() && p.charAt(j+1) == '*'){
            return solve(s,p,i,j+2) || matched && solve(s,p,i+1,j);
        }
        
            return matched && solve(s,p,i+1,j+1);
        
    }
}