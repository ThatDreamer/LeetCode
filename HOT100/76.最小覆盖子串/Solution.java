/**
 * 功能描述
 * LeetCodeHOT100：76.最小覆盖子串
 * 解法：滑动窗口+HashMap
 */
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int n = s.length();
        int m = t.length();
        for(int i=0; i<m; i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0)+1);
        }
        int l = 0;
        int res = Integer.MAX_VALUE;
        int index = -1;
        for(int r=0; r<n; r++){
            map1.put(s.charAt(r), map1.getOrDefault(s.charAt(r), 0)+1);
            while(l<=r && check(map1, map2)){
                // System.out.println(l+" "+r);
                if((r-l+1)<res){
                    res = r-l+1;
                    index = l;
                }
                map1.put(s.charAt(l), map1.getOrDefault(s.charAt(l), 0)-1);
                l++;
            }
        }
        // System.out.println(index+" "+res);
        if(index == -1) return "";
        return s.substring(index, index+res);
    }

    public static boolean check(Map<Character, Integer> map1, Map<Character, Integer> map2){
        for(char key: map2.keySet()){
            if(map1.getOrDefault(key, 0) < map2.get(key))
                return false;
        }
        return true;
    }

}