/**
 * 功能描述
 * LeetCodeHOT100：10.正则表达式匹配
 * 解法1：动态规划，时间复杂度为O(m*n)
 */

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i=0; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(p.charAt(j-1)=='*')
                {
                    if(dp[i][j-2] || (isMatch(s, p, i-1, j-2) && dp[i-1][j]))
                        dp[i][j] = true;
                }
                else if(isMatch(s, p, i-1, j-1))
                    dp[i][j] = dp[i-1][j-1];
            }
        }
        return dp[n][m];
    }

    public boolean isMatch(String s, String p, int x, int y){
        if(x == -1)
            return false;
        if(s.charAt(x) == p.charAt(y))
            return true;
        if(p.charAt(y) == '.')
            return true;
        return false;
    }

}