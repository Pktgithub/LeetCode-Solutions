class Solution {
    class Tuple {
        int distance;
        int row;
        int column;

        Tuple(int dist, int row, int col) {
            this.distance = dist;
            this.row = row;
            this.column = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));
        int m = heights.length;
        int n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        effort[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();
            int diff = curr.distance;
            int r = curr.row;
            int c = curr.column;

            if (r == m - 1 && c == n - 1)
                return diff;

            for (int i = 0; i < 4; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                if (newr >= 0 && newr < m && newc >= 0 && newc < n) {
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[newr][newc]), diff);

                    if (newEffort < effort[newr][newc]) {
                        effort[newr][newc] = newEffort;
                        pq.add(new Tuple(newEffort, newr, newc));
                    }
                }
            }
        }

        return 0;
    }
}