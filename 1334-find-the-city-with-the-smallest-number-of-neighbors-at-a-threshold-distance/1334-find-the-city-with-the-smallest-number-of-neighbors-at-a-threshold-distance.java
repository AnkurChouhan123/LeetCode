class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int max = (int) 1e8;
        int[][] grid = new int[n][n];
        for (int[] a : grid)
            Arrays.fill(a, max);

        for (int i = 0; i < n; i++) {
            grid[i][i] = 0;
        }

        for (int[] a : edges) {
            grid[a[0]][a[1]] = a[2];
            grid[a[1]][a[0]] = a[2];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                    if (grid[j][i] != max && grid[i][k] != max)
                        grid[j][k] = Math.min(grid[j][k], grid[j][i] + grid[i][k]);
                }
            }
        }

        int countMax = n;
        int city = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(grid[i][j] <= distanceThreshold){
                    count++;
                }
            }

            if(count <= countMax){
                city = i;
                countMax = count;
            }
        }

        return city;

    }
}