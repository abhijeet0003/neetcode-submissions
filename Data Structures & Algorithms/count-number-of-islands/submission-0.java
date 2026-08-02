class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int[][] visited = new int[rows][cols];
        for(int i =0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == '1' && visited[i][j] != 1){
                    count++;
                    dfs(grid,i,j,visited,rows,cols);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int row , int col ,int[][] visited,int rows,int cols){
        if(row < 0||row>=rows||col<0||col>=cols){
            return;
        }

        if(visited[row][col] == 1|| grid[row][col] =='0'){
            return;
        }
       visited[row][col] = 1;
        dfs(grid,row+1,col,visited,rows,cols);
        dfs(grid,row-1,col,visited,rows,cols);
        dfs(grid,row,col-1,visited,rows,cols);
        dfs(grid,row,col+1,visited,rows,cols);

    }
}
