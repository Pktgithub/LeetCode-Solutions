class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        int freshOranges=0;

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i , j});
                } 
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges==0){
            return 0;
        }

        int minutes = 0;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0 , -1},
            {0 , 1}
        };

        while(!q.isEmpty()) {
            int size = q.size();
            boolean rottenThisMinute = false;

            for (int i = 0 ; i < size; i++) {
                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                for ( int[] dir : directions ) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if ( nr < 0 || nc < 0 || nr >= m || nc >= n) {
                        continue;
                    }

                    if (grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshOranges--;
                        q.offer(new int[] {nr,nc} );
                        rottenThisMinute= true;
                    }
                } 
            }
            if (rottenThisMinute) {
                minutes++;
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }
}