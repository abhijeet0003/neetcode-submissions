class Solution {
    public void solve(char[][] board) {



int R = board.length, C = board[0].length;
for (int r = 0; r < R; r++) { dfs(board, r, 0, R, C); dfs(board, r, C - 1, R, C); }
for (int c = 0; c < C; c++) { dfs(board, 0, c, R, C); dfs(board, R - 1, c, R, C); }
for (int r = 0; r < R; r++)
for (int c = 0; c < C; c++) {
if (board[r][c] == 'O') board[r][c] = 'X'; // captured
else if (board[r][c] == '#') board[r][c] = 'O'; // restore safe
}
}
void dfs(char[][] b, int r, int c, int R, int C) {
if (r < 0 || r >= R || c < 0 || c >= C || b[r][c] != 'O') return;
b[r][c] = '#';
dfs(b, r - 1, c, R, C); dfs(b, r + 1, c, R, C);
dfs(b, r, c - 1, R, C); dfs(b, r, c + 1, R, C);
}

        
    }

