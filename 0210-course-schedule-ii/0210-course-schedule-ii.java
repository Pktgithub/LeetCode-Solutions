class Solution {

    private boolean dfs(int start, int[] vis,
                        ArrayList<ArrayList<Integer>> adj,
                        Stack<Integer> st) {

        vis[start] = 1;

        for (int padosi : adj.get(start)) {

            if (vis[padosi] == 1) {
                return false;
            }

            if (vis[padosi] == 0) {
                if (!dfs(padosi, vis, adj, st)) {
                    return false;
                }
            }
        }

        vis[start] = 2;
        st.push(start);

        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] vis = new int[numCourses];

        Stack<Integer> st = new Stack<>();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }

        
        for (int i = 0; i < numCourses; i++) {

            if (vis[i] == 0) {
                if (!dfs(i, vis, adj, st)) {
                    return new int[0];
                }
            }
        }

        
        int[] ans = new int[numCourses];

        int i = 0;

        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }

        return ans;
    }
}