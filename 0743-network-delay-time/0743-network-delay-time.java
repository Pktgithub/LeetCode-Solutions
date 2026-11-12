class Solution {
    class Pair {
        int node;
        int dis;

        Pair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int node = edge[0];
            int neighbour = edge[1];
            int time = edge[2];

            adj.get(node).add(new int[] {neighbour, time});
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> Integer.compare(a.dis, b.dis));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Pair(k, 0));
        dist[k] = 0;

        while(!pq.isEmpty()) {
            int time = pq.peek().dis;
            int node = pq.peek().node;
            pq.poll();

            if (time > dist[node]) {
                continue;
            }

            for (int[] arr : adj.get(node)) {
                int edgeNode = arr[0];
                int edgeTime = arr[1];

                if (time + edgeTime < dist[edgeNode]) {
                    dist[edgeNode] = time + edgeTime;
                    pq.add(new Pair(edgeNode, dist[edgeNode]));
                }
            }
        }

        int minimum = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            minimum = Math.max(minimum, dist[i]);
        }

        return minimum;
    }
}