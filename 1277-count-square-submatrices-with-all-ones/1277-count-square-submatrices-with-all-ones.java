class Solution {
    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] pre = new int[m][n];
        pre[0][0] = matrix[0][0];

        for (int i = 1; i < n; i++) {
            pre[0][i] = matrix[0][i] + pre[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            pre[i][0] = matrix[i][0] + pre[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + matrix[i][j];
            }
        }

        int count  = 0;

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                count += checkCount(pre,i,j);
            }
        }

        return count;
    }

    int checkCount(int[][] pre, int idx1, int idx2) {
        int i = idx1;
        int j = idx2;

        int count = 0;


        while(i>=0 && j>=0){
            if(valid(pre,i,j,idx1,idx2)) count++;
            // else return cnt;
            i--;
            j--;
        }

        return count;

    }

    boolean valid(int[][] pre, int i, int j, int idx1, int idx2) {

        if(idx1 == 0 && idx2 == 0) return pre[0][0] == 1;

        int total = (idx1 - i + 1) * (idx2 - j + 1);

        int sum = -1;

        if (i > 0 && j > 0) {
            sum = pre[idx1][idx2] - (pre[idx1][j - 1] + pre[i - 1][idx2] - pre[i - 1][j - 1]);
        }
        else if(i>0){
            sum = pre[idx1][idx2] -  pre[i - 1][idx2];
        }
        else if(j>0){
             sum = pre[idx1][idx2] -  pre[idx1][j - 1];
        }

        return sum == total;
    }
}