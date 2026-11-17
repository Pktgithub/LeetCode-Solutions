import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class tuple {
        int first;
        int second;
        int third;

        tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

      
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1) return 1;

        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(1, 0, 0)); 

        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 1;

        int[] dr = { -1, 0, 1, 0, -1, 1, -1, 1 };
        int[] dc = { 0, 1, 0, -1, -1, 1, 1, -1 };

        while (!q.isEmpty()) {
            tuple curr = q.poll();
            int dis = curr.first;
            int rw = curr.second;
            int cl = curr.third;

            
            for (int i = 0; i < 8; i++) {
                int newr = rw + dr[i];
                int newc = cl + dc[i];

                if (newr >= 0 && newr < n && newc >= 0 && newc < n 
                    && grid[newr][newc] == 0 && dis + 1 < dist[newr][newc]) {
                    
                    dist[newr][newc] = dis + 1;
                    if (newr == n - 1 && newc == n - 1) {
                        return dis + 1;
                    }
                    q.add(new tuple(dis + 1, newr, newc));
                }
            }
        }

        return -1;
    }
}
