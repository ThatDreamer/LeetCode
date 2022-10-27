/**
 * 功能描述
 * LeetCodeHOT100：11.盛最多水的容器
 * 解法：双指针，时间复杂度为O(n)
 */
class Solution {
    public int maxArea(int[] height) {
        int l=0, r=height.length-1;
        int res = 0;
        while(l<r){
            // System.out.println(l+" "+r);
//          简洁写法，res = height[l]<height[r]?Math.max(res, height[l++]*(r-l):Math.max(res, height[r--]*(r-l);
            res = Math.max(res, Math.min(height[l], height[r])*(r-l));
            if(height[l]>height[r])
                r--;
            else
                l++;
        }
        return res;
    }
}