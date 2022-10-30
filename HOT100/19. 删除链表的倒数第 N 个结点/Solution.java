/**
 * 功能描述
 * LeetCodeHOT100：19.删除链表的倒数第N个结点
 * 解法：快慢指针，时间复杂度为O(n)，注意删除头节点的情况
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        while(n != 0){
            fast = fast.next;
            n--;
        }
        if(fast == null) return head.next;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}