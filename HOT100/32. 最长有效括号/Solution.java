/**
 * 功能描述
 * LeetCodeHOT100：32.最长有效括号
 * 解法：动态规划，时间复杂度为O(n)
 */
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n<2) return 0;
        int[] dp = new int[n];
        int res = 0;
        for(int i=1; i<n; i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = ((i>=2)?dp[i-2]:0)+2;
                    // System.out.println(dp[i]);
                }

                else if((i-dp[i-1])>0 && s.charAt(i-dp[i-1]-1)=='(')
                    dp[i] = dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}