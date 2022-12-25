class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid;
        while(l<=r){
            mid = (l+r)/2;
            // System.out.println(l+" "+r+" "+mid);
            if(nums[mid]>target){
                if(nums[l]>target)
                    l = l+1;
                else
                    r = mid-1;
            }
            else if(nums[mid]<target){
                if(nums[r]<target)
                    r = r-1;
                else
                    l = mid+1;
            }
            else
                return mid;
        }
        return -1;
    }

}