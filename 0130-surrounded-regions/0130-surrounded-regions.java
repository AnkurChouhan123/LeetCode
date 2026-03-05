class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if((i == 0 || j == 0 
                   ||i == m-1 || j == n-1)
                    && board[i][j] == 'O' ){
                    q.add(new int[]{i,j});
                    board[i][j] = '@';
                }
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int idx = 0;idx<size;idx++){
                int[] arr = q.poll();
                int i = arr[0];
                int j = arr[1];
                if(i-1>=0 && board[i-1][j] == 'O'){
                    q.add(new int[]{i-1,j});
                    board[i-1][j] = '@';
                }
                if(i+1<m && board[i+1][j] == 'O'){
                    q.add(new int[]{i+1,j});
                    board[i+1][j] = '@';
                }
                if(j-1>=0 && board[i][j-1] == 'O'){
                    q.add(new int[]{i,j-1});
                    board[i][j-1] = '@';
                }
                if(j+1 < n && board[i][j+1] == 'O'){
                    q.add(new int[]{i,j+1});
                    board[i][j+1] = '@';
                }
            }
        }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '@'){
                    board[i][j] ='O';
                }
            }
        }


    }
}