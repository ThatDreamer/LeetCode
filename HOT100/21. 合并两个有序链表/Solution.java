/**
 * 功能描述
 * LeetCodeHOT100：21.合并两个有序的链表
 * 解法：迭代，时间复杂度为O(m+n)
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {23. 合并K个升序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode ans = res;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                res.next = list1;
                list1 = list1.next;
            }
            else{
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        if(list1!=null)
            res.next = list1;
        else
            res.next = list2;
        return ans.next;
    }
}