import java.util.HashMap;

/**
 * 功能描述
 * LeetCodeTop100：3.无重复字符的最长子串
 * 题目描述：给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例1：
 *      输入；s = "abcabcbb"；输出：3；解释：因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例2：
 *      输入；s = "pwwkew"；输出：3；解释：因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 提示：
 *      0 <= s.length <= 5 * 104
 *      s 由英文字母、数字、符号和空格组成
 * 思路：滑动窗口+HashMap
 * @author: scott
 * @date: 2022年10月23日 12:01
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int diff = 0;
        int res = 0;
        int l = 0, r = 0;
        // map.put(s.charAt(0), 1);
        while(l<=r&&r<s.length()){
            while(l<=r&&r<s.length()&&map.getOrDefault(s.charAt(r), 0)==0){
                map.put(s.charAt(r), 1);
                r++;
            }
            // System.out.println(l+" "+r);
            res = Math.max(res, r-l);
            map.put(s.charAt(l), 0);
            l++;
        }
        return res;
    }
}
