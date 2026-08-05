class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> l = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int[] a:edges){
            l.get(a[0]).add(a[1]);
            l.get(a[1]).add(a[0]);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(l,visited,i);
            }
        }
        return count;
    }
    public void dfs(List<List<Integer>> a,boolean[] visited,int node){
        
        if(!visited[node]){
            visited[node] = true;
            for(int nodes:a.get(node)){
                if(!visited[nodes]){
                    dfs(a,visited,nodes);
                }
            }
        }
    }
    
}
