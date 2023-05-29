/**
 * 功能描述
 * LeetCodeHOT100：76.最小覆盖子串
 * 解法：O(n)复杂度优化，用一个计数器代替遍历字符串判断是否满足覆盖要求
 */
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map2 = new HashMap<>();
        int n = s.length();
        int m = t.length();
        int cnt = m;
        for(int i=0; i<m; i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0)+1);
        }
        int l = 0;
        int res = Integer.MAX_VALUE;
        int index = -1;
        for(int r=0; r<n; r++){
            if(map2.containsKey(s.charAt(r))){
                map2.put(s.charAt(r), map2.get(s.charAt(r))-1);
                if(map2.get(s.charAt(r))>=0)
                    cnt--;
            }
            while(l<=r && cnt<=0){
                // System.out.println(l+" "+r);
                if((r-l+1)<res){
                    res = r-l+1;
                    index = l;
                }
                if(map2.containsKey(s.charAt(l))){
                    map2.put(s.charAt(l), map2.get(s.charAt(l))+1);
                    if(map2.get(s.charAt(l))>0)
                        cnt++;
                }
                l++;
            }
        }
        // System.out.println(index+" "+res);
        if(index == -1) return "";
        return s.substring(index, index+res);
    }
}