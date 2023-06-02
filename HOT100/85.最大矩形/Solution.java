/**
 * 功能描述
 * LeetCodeHOT100：85.最大矩形
 * 解法：单调栈
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int n = matrix.length;
        if(n==0) return 0;
        int m = matrix[0].length;
        int[][] heights = new int[n][m];
        for(int j=0; j<m; j++){
            heights[0][j] = matrix[0][j]-'0';
            for(int i=1; i<n; i++)
                heights[i][j] = matrix[i][j]=='0'?0:heights[i-1][j]+1;
        }
        for(int i=n-1; i>=0; i--){
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            int[] area = new int[m];
            for(int j=1; j<=m; j++){
                int tmp = (j!=m)?heights[i][j]:-1;
                while(!stack.isEmpty() && heights[i][stack.peek()]>tmp){
                    int top = stack.pop();
                    area[top] += (j-top)*heights[i][top];
                }
                if(j!=m){
                    int t = stack.isEmpty()?-1:stack.peek();
                    area[j] += (j-t-1)*heights[i][j];
                    stack.push(j);
                }

            }
            for(int j=0; j<m; j++){
                res = Math.max(res, area[j]);
            }

        }
        return res;
    }
}