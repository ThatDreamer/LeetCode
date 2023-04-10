/**
 * 功能描述
 * LeetCodeHOT100：62.不同路径
 * 解法：经典二维dp，时间复杂度为O(n*m)，可以优化时间为O(n)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[] x = new int[n];
        for(int i=0; i<n; i++) x[i] = 1;

        for(int i=1; i<m; i++){
            int pre = 1;
            for(int j=1; j<n; j++){
                int cur = pre+x[j];
                x[j] = cur;
                pre = cur;
            }
        }
        return x[n-1];
    }
}