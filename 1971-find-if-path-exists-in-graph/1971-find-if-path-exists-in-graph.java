class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        visited[source] = true;
        q.add(source);

        while (!q.isEmpty()) {
            int current = q.poll();

            if(current == destination) {
                return true;
            }

            for(int neighbour : adj.get(current)) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        return false;
    }
}