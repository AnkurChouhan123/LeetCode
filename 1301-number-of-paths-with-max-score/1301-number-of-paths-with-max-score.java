class Solution {

    int mod = (int) (1e9 + 7);

    public int[] pathsWithMaxScore(List<String> board) {
        char[][] arr = new char[board.size()][board.get(0).length()];

        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).length(); j++) {
                char ch = board.get(i).charAt(j);
                arr[i][j] = ch;
            }
        }

        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[0].length; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        // }

        maxDP = new Integer[arr.length + 1][arr.length + 1];

        int max = max(arr, arr.length - 1, arr[0].length - 1);


        if (max < 0)
            return new int[] { 0, 0 };
        countDP = new Integer[arr.length+1][arr[0].length+1][max+1];

        int count = count(arr, arr.length - 1, arr[0].length - 1, max);

        return new int[] { max, count };
    }

    Integer[][] maxDP;

    int max(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || grid[i][j] == 'X')
            return -(int) (1e7);
        if (i == 0 && j == 0)
            return 0;

        if (maxDP[i][j] != null)
            return maxDP[i][j];

        long up = 0;
        long up_left = 0;
        long left = 0;

        // if (i >= 0 && j >= 0 && grid[i][j] != 'X') {

        up = ((grid[i][j] == 'S' ? 0 : grid[i][j] - '0') + max(grid, i - 1, j)) % mod;
        up_left = ((grid[i][j] == 'S' ? 0 : grid[i][j] - '0') + max(grid, i - 1, j - 1)) % mod;
        left = ((grid[i][j] == 'S' ? 0 : grid[i][j] - '0') + max(grid, i, j - 1)) % mod;
        // }

        maxDP[i][j] = Math.max((int)up_left, Math.max((int)up, (int)left));

        return maxDP[i][j];
    }

    Integer[][][] countDP;

    int count(char[][] grid,int i,int j,int target){

        if(i == 0 && j == 0 && target == 0) return 1;
        // if(target < 0) return 0;

        if(i < 0 || j < 0 || grid[i][j] == 'X') return 0; 

        if(countDP[i][j][target] != null) return countDP[i][j][target];


        long up = 0;
        long left = 0;
        long up_left = 0;

       if(grid[i][j] == 'S' || (grid[i][j] != 'S' && grid[i][j] - '0' <= target)){

        up = count(grid, i - 1, j, target - (grid[i][j] == 'S' ? 0 : grid[i][j] - '0')) % mod;
        up_left = count(grid, i - 1, j-1, target - (grid[i][j] == 'S' ? 0 : grid[i][j] - '0')) % mod;
        left = count(grid, i, j - 1, target - (grid[i][j] == 'S' ? 0 : grid[i][j] - '0')) % mod;
       }

        countDP[i][j][target] = (int)(up + left + up_left) % mod;
        return countDP[i][j][target];
        
    }
}