class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int[] a:prerequisites){
            int from = a[1];
            int to = a[0];
            adj.get(from).add(to);
        }
        for(int u=0;u<numCourses;u++){
            for(int a:adj.get(u)){
                indegree[a]++;
            }
        }
        for(int i =0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int a = q.poll();
            count++;
            for(int d:adj.get(a)){
                indegree[d]--;
                if(indegree[d]==0){
                    q.offer(d);
                }
            }
        }
        return count == numCourses;
    }
}
