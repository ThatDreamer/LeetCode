/**
 * 功能描述
 * LeetCodeHOT100：78.单词搜索
 * 解法：回溯+剪枝
 */
class Solution {

    public static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static boolean dfs(int index, char[][] board, String word, int x, int y){
        if(x<0 || x>=board.length || y<0 || y>= board[0].length || board[x][y]=='.' || board[x][y] != word.charAt(index)){
            return false;
        }
        if(index == (word.length()-1)){
            return true;
        }
        char tmp = board[x][y];
        board[x][y] = '.';
        for(int i=0; i<4; i++){
            int tx = x+dir[i][0];
            int ty = y+dir[i][1];
            if(dfs(index+1, board, word, tx, ty)) return true;
        }
        board[x][y] = tmp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dfs(0, board, word, i, j)) return true;
            }
        }
        return false;
    }
}