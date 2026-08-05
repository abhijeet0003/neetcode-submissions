class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        for(int[] a:times){
            int from = a[0];
            int to = a[1];
            int weight = a[2];
            adj.get(from).add(new int[]{to, weight});
        }
        pq.offer(new int[]{k, 0});
        while(!pq.isEmpty()){
            int[] node= pq.poll();
            int n1 = node[0];
            int d = node[1];

       //     if (d > dist[n1]) continue;

            for(int[] edge : adj.get(n1)){
                int v = edge[0];
                int weight = edge[1];
                if(dist[n1] + weight < dist[v]){
                    dist[v] = dist[n1] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxDist = Math.max(maxDist, dist[i]);
        }
        return maxDist;
    }
}