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