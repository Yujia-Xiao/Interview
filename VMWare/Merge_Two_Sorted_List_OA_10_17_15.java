/*
merge two sorted list - Leet code
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode p=preHead;
        ListNode ll1 = l1;
        ListNode ll2 = l2;
        
        while(ll1!=null && ll2!=null){
            if(ll1.val<ll2.val){
                p.next=ll1;
                ll1=ll1.next;
            }
            else{
                p.next=ll2;
                ll2=ll2.next;
            }
            p=p.next;
        }
        while(ll1!=null){
            p.next=ll1;
            p=p.next;
            ll1=ll1.next;
        }
        while(ll2!=null){
            p.next=ll2;
            p=p.next;
            ll2=ll2.next;
        }
        
        return preHead.next;
    }
}