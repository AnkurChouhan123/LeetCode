class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        this.grid = grid;
        int n = grid.length;
        if (n == 1) {
            if (grid[0][0] == 0)
                return 1;
            if (grid[0][0] == 1)
                return -1;
        }

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        visited = new boolean[n][n];

        // i, j, wt
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {

            int[] arr = q.poll();
            int i = arr[0];
            int j = arr[1];
            int wt = arr[2];

            if (i == n - 1 && j == n - 1)
                return wt;

            if (isSafe(i - 1, j)) {
                q.add(new int[] { i - 1, j, wt + 1 });
                visited[i - 1][j] = true;
            }

            if (isSafe(i + 1, j)) {
                q.add(new int[] { i + 1, j, wt + 1 });
                visited[i + 1][j] = true;
            }

            if (isSafe(i, j - 1)) {
                q.add(new int[] { i, j - 1, wt + 1 });
                visited[i][j - 1] = true;
            }

            if (isSafe(i, j + 1)) {
                q.add(new int[] { i, j + 1, wt + 1 });
                visited[i][j + 1] = true;
            }

            if (isSafe(i - 1, j - 1)) {
                q.add(new int[] { i - 1, j - 1, wt + 1 });
                visited[i - 1][j - 1] = true;
            }

            if (isSafe(i - 1, j + 1)) {
                q.add(new int[] { i - 1, j + 1, wt + 1 });
                visited[i - 1][j + 1] = true;
            }

            if (isSafe(i + 1, j - 1)) {
                q.add(new int[] { i + 1, j - 1, wt + 1 });
                visited[i + 1][j - 1] = true;
            }

            if (isSafe(i + 1, j + 1)) {
                q.add(new int[] { i + 1, j + 1, wt + 1 });
                visited[i + 1][j + 1] = true;
            }
        }

        return -1;
    }

    boolean[][] visited;
    int[][] grid;

    boolean isSafe(int i, int j) {
        if (i < 0 || j < 0
            || i == grid.length || j == grid.length 
            || grid[i][j] == 1 || visited[i][j])
            return false;
        
        return true;
    }
}