package day1.addtwonumbers2;

/**
 * 难度中等4617给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Demo1 {
    class ListNode{
        int val;

        ListNode next;

        ListNode(int i){
            val = i;
        }
    }
//
//    public int getNum(ListNode){
//        return 0;
//    }

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0:l2.val) + ((l1 == null) ? 0:l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1:l1.next;
            l2 = (l2 == null) ? l2:l2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}
