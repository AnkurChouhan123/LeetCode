import java.util.*;

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        dp = new Integer[scores.length][ages.length];

        int n = scores.length;
        int[][] players = new int[n][2];

        for (int i = 0; i < n; i++) {
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }

        Arrays.sort(players, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        return solve(players, 0, -1);
    }

    Integer[][] dp;

    int solve(int[][] players, int i, int prev) {

        if (i == players.length) return 0;

        if(dp[i][prev+1] != null) return dp[i][prev+1];


        int notPick = solve(players, i + 1, prev);

        int pick = 0;

        if (prev == -1 || players[i][1] >= players[prev][1]) {
            pick = players[i][1] + solve(players, i + 1, i);
        }

        dp[i][prev+1] = Math.max(pick, notPick);

        return dp[i][prev+1];
    }
}