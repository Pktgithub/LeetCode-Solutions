
class Solution {
    class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb,
                                 int start_node, int end_node) {

       
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p));
        }

        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.prob, a.prob)
        );

        
        double[] prob = new double[n];

        prob[start_node] = 1.0;

        pq.add(new Pair(start_node, 1.0));

        
        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            double currProb = curr.prob;

            
            if (currProb < prob[node]) {
                continue;
            }

           
            if (node == end_node) {
                return currProb;
            }

            for (Pair it : adj.get(node)) {

                int adjNode = it.node;
                double edgeProb = it.prob;

                double newProb = currProb * edgeProb;

                if (newProb > prob[adjNode]) {

                    prob[adjNode] = newProb;

                    pq.add(new Pair(adjNode, newProb));
                }
            }
        }

        return 0.0;
    }
}
