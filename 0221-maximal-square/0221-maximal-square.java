class Solution {
    public int maximalSquare(char[][] matrix) {
       int[][] prefix = prefix(matrix);
    //    dp = new Integer[matrix.length][matrix[0].length];
       int max = 0;

       for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
              max = Math.max(max,findMax(prefix,i,j));
            }
        }


        return max;
    }


    int[][] prefix(char[][] arr) {

        int m = arr.length;
        int n = arr[0].length;
        int[][] prefix = new int[m][n];

        prefix[0][0] = arr[0][0]-'0';

        for (int i = 1; i < m; i++) {
            prefix[i][0] = prefix[i - 1][0] + arr[i][0]-'0';
        }

        for (int i = 1; i < n; i++) {
            prefix[0][i] = prefix[0][i - 1] + arr[0][i]-'0';
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefix[i][j] = arr[i][j]-'0' + prefix[i - 1][j]
                        + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }
        return prefix;
    }

    int findMax(int[][] prefix, int idx1, int idx2) {

        int i = idx1;
        int j = idx2;

        int max = 0;

        while (i >= 0 && j >= 0) {

           
            // if(dp[i][j] != null){
            //     max += dp[i][j];
            //     break;
            // }
            int len = (idx1 - i + 1) * (idx2 - j + 1);
            int val = 0;
            if (i == 0 && j == 0) {
                val = prefix[idx1][idx2];
            }
            else if(i>0 && j>0){
                val = prefix[idx1][idx2] - (prefix[idx1][j-1] 
                                             + prefix[i-1][idx2] - prefix[i-1][j-1]);
            }
            else if(j == 0){
                val = prefix[idx1][idx2] - prefix[i-1][idx2];
            }
            else if(i == 0){
                val = prefix[idx1][idx2] - prefix[idx1][j-1];
            }


            if(val == len){
              max = val;
              i--;
              j--;
            } 
             
            else break;
        }
        return max;
    }

}