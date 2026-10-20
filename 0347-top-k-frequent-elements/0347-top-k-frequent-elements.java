class Solution {
    class Pair {
        int frequency;
        int number;

        Pair(int frequency, int number ) {
            this.frequency = frequency;
            this.number = number;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put( num, map.getOrDefault(num , 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) ->Integer.compare(a.frequency, b.frequency)
        );

        for (int num : map.keySet()) {
            pq.offer(new Pair(map.get(num), num));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int index = 0;

        while (!pq.isEmpty()) {
            ans[index++] = pq.poll().number;
        }

        return ans;
    }
}