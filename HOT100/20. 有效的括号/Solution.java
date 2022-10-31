/**
 * 功能描述
 * LeetCodeHOT100：20.有效的括号
 * 解法：括号匹配，可以用栈，时间复杂度为O(n)
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
                st.push(i);
            else{
                if(!st.empty() && s.charAt(st.peek())=='(' && s.charAt(i)==')')
                    st.pop();
                else if(!st.empty() && s.charAt(st.peek())=='[' && s.charAt(i)==']')
                    st.pop();
                else if(!st.empty() && s.charAt(st.peek())=='{' && s.charAt(i)=='}')
                    st.pop();
                else
                    return false;
            }
        }
        if(st.empty())
            return true;
        else
            return false;
    }
}