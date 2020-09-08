package day1.addtwonumbers2;

public class Demo2 {
    class ListNode{
        int val;
        ListNode next;

        ListNode(int i){
            val = i;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode prev = new ListNode(0);
        ListNode head = prev.next;
        int carry = 0; //carry为元素相加的进位

        while(l1 != null || l2 != null || carry != 0){
            ListNode cur = new ListNode(0); //cur为相加后的链表
            int sum = ((l2 == null) ? 0:l2.val) + ((l1 == null) ? 0:l1.val) + carry;
            cur.val = sum % 10; //val相加后原位置的结果数字
            carry = sum/10;
            prev.next = cur; //链表继续向下操作
            prev = cur;
        }
        return head.next;
    }
}
