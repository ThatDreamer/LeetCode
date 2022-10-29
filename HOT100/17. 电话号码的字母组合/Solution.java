/**
 * 功能描述
 * LeetCodeHOT100：17.电话号码的字母组合
 * 解法：dfs，时间复杂度为O(4^n),n为给定的字符串长度
 */
class Solution {
    List<String> res = new ArrayList<>();
    int[] s = {0, 3, 6, 9, 12, 15, 19, 22, 26}; //控制每层的遍历边界
    public void dfs(int p, String digits, StringBuilder sb){
        if(p==digits.length()){
            res.add(sb.toString());
            return ;
        }
        int index = digits.charAt(p)-'2';
        int start = s[index];
        int end = s[index+1];
        for(int i=start; i<end; i++){
            sb.append((char)('a'+i));
            dfs(p+1, digits, sb);
            sb.delete(sb.length()-1, sb.length());
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return res;
        dfs(0, digits, new StringBuilder());
        return res;
    }
}