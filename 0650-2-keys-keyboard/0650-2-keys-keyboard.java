class Solution {
    public int minSteps(int n) {
        if (n == 1)
            return 0;
        return solve(n, 0, 1);
    }

    int solve(int n, int available, int onScreen) {

        if (onScreen == n)
            return 0;
            if(onScreen > n) return (int)1e7;

        int paste = (int) 1e7;
        if (available > 0) {
            paste = 1 + solve(n, available, onScreen + available);
        }
        int copy = (int) 1e7;
            if(available!=onScreen)
             copy = 1 + solve(n, onScreen, onScreen);
        

        return Math.min(copy, paste);
    }
}