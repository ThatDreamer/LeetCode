/**
 * 功能描述
 * LeetCodeHOT100：96.不同的二叉搜索树
 * 解法：动态规划
 */
class Solution {
    public int numTrees(int n) {
        if(n<2) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }

        return dp[n];
    }
}