class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            if (ds.find(u) == ds.find(v)) {
                return edge; // already connected -> this is the redundant edge!
            }

            ds.union(u, v);
        }

        return new int[]{-1, -1}; // won't happen per problem constraints
    }
}

class DisjointSet {
    int[] rank;
    int[] parent;
    int count;

    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        count = n;

        for (int i = 1; i <= n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
            rank[rootB]++;
        }
        count--;
    }

    public int getCount() {
        return count;
    }

    public int countComponents() {
        int c = 0;
        for (int i = 1; i < parent.length; i++) {
            if (find(i) == i) {
                c++;
            }
        }
        return c;
    }
}