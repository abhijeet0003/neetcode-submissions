class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int rows = grid.length;
        int cols = grid[0].length;
                Queue<int[]> q = new LinkedList<>();

        for(int i =0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == 1)
                fresh++;
                else if(grid[i][j] == 2)
                q.offer(new int[]{i,j,0});
            }
        }
        int minutes = 0;
        int[][] rd ={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] rct = q.poll();
            int r = rct[0];
            int c= rct[1];
            int t = rct[2];
            minutes = Math.max(minutes,t);
            for(int[] nr:rd){
                int newrow= r+nr[0];
                int newcol = c+nr[1];
                if(newrow <0 ||newrow >= rows||newcol<0||newcol>=cols)
                continue;
                if(grid[newrow][newcol] == 1){
                    grid[newrow][newcol] = 2;
                    fresh--;
                    int newtime = t+1;
                    q.offer(new int[]{newrow,newcol,newtime});
                }
            }
        }
        return fresh==0?minutes:-1;
    }
}
