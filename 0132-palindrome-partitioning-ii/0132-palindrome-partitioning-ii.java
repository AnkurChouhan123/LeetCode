class Solution {
    public int minCut(String s) {
        this.s = s;
        dp = new Integer[s.length()+1];
       return solve(0) - 1;
    }

    String s;

    Integer[]dp;

    int solve(int i) {

        if (i == s.length()) {
          return 0;
        }

        if (dp[i] != null) return dp[i];

        int min = s.length();

        for (int k = i; k < s.length(); k++) {
            if (isPalindrome(i,k)) {
                int cuts = 1 + solve(k + 1);
                min = Math.min(cuts,min);
            }
        }

        return dp[i] = min;

    }

    boolean isPalindrome(int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}