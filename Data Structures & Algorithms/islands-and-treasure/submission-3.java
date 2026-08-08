class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir : dirs) {
                int r = curr[0] + dir[0], c = curr[1] + dir[1];
                if(r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 2147483647) {
                    grid[r][c] = grid[curr[0]][curr[1]] + 1;
                    q.add(new int[]{r, c});
                }
            }
        }

    }
}