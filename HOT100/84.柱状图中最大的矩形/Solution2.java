/**
 * 功能描述
 * LeetCodeHOT100：84.柱状图中最大的矩形
 * 解法：单调栈，写法2
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> q = new ArrayDeque();
        q.addLast(0);
        int n = heights.length;
        int[] area = new int[n];
        for(int i=1; i<=n; i++){
            int tmp = (i!=n)?heights[i]:-1;
            while(!q.isEmpty() && heights[q.getLast()]>tmp){
                int top = q.removeLast();
                area[top] += (i-top)*heights[top];
            }
            if(i!=n){
                int t = q.isEmpty()?-1:q.getLast();
                area[i] += (i-t-1)*heights[i];
                q.addLast(i);
            }
        }
        int res = 0;
        for(int i=0; i<n; i++)
            res = Math.max(res, area[i]);
        return res;
    }
}