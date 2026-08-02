class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] vis = new int[rows][cols];
        int area = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1){
                    area = Math.max(area,dfs(grid,i,j,rows,cols,vis));
                }
            }
        }
        return area;
    }

    public int dfs(int[][] grid,int i,int j,int rows,int cols,int[][] vis){
        if(i<0||i>=rows||j<0||j>=cols){
            return 0;
        }
        if(grid[i][j] == 0 || vis[i][j] == 1){
            return 0;
        }
        vis[i][j] = 1;
        return 1+dfs(grid,i+1,j,rows,cols,vis)+dfs(grid,i-1,j,rows,cols,vis)
        +dfs(grid,i,j+1,rows,cols,vis)+dfs(grid,i,j-1,rows,cols,vis);
    }
}
