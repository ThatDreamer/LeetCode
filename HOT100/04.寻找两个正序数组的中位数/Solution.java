/**
 * 功能描述
 * LeetCodeHOT100：4.寻找两个正序数组的中位数
 * 解法1：用双指针合并数组，然后返回中位数，时间复杂度为O(m+n)
 * @author: scott
 * @date: 2022年10月24日 10:01
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        int l = 0, r = 0, index = 0;
        while (l < m || r < n) {
            if (l < m && r < n)
                nums[index++] = nums1[l] < nums2[r] ? nums1[l++] : nums2[r++];
            else if (l < m)
                nums[index++] = nums1[l++];
            else if (r < n)
                nums[index++] = nums2[r++];
        }

        if ((m + n) % 2 == 1)
            return nums[(m + n) / 2];
        else
            return (nums[(m + n) / 2] + nums[(m + n) / 2 - 1]) / 2.0;
    }
}