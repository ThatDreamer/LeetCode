class Solution {
    public int search(int[] nums, int target) {
        int index = searchSmaller(nums, nums[0], 0, nums.length-1);
        // System.out.println(index);
        int res = searchEqual(nums, target, 0, index);
        // System.out.println(res);
        if(res!=-1) return res;
        res = searchEqual(nums, target, index+1, nums.length-1);
        // System.out.println(res);
        if(res!=-1) return res;
        return -1;
    }

    public int searchSmaller(int[] nums, int target, int x, int y){
        int l = x;
        int r = y;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]<target)
                r = mid-1;
            else
                l = mid+1;
        }
        if(nums[r]<target)
            return r-1;
        else
            return r;
    }
    public int searchEqual(int[] nums, int target, int x, int y){
        int l = x;
        int r = y;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]<target)
                l = mid+1;
            else if(nums[mid]>target)
                r = mid-1;
            else
                return mid;
        }
        return -1;
    }
}