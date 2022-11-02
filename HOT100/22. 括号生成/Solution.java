/**
 * 功能描述
 * LeetCodeHOT100：22.括号生成
 * 解法：回溯dfs，时间复杂度小于O(2^n)
 */
class Solution {
    List<String> res = new ArrayList<>();
    public void dfs(int l, int r, StringBuilder sb, int n){
        if(l>n || r>n || l<r)
            return ;
        if(l==r && l==n){
            res.add(sb.toString());
            return ;
        }
        dfs(l+1, r, sb.append('('), n);
        sb.delete(sb.length()-1, sb.length());
        dfs(l, r+1, sb.append(')'), n);
        sb.delete(sb.length()-1, sb.length());
    }
    public List<String> generateParenthesis(int n) {
        dfs(0, 0, new StringBuilder(), n);
        return res;
    }
}