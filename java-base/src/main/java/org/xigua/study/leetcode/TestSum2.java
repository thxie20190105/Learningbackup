package org.xigua.study.leetcode;

/**
 * @author xigua
 * @description
 * @date 2020/6/2
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class TestSum2 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(3)
                .next = new ListNode(2)
                .next = new ListNode(9);

        ListNode list2 = new ListNode(3)
                .next = new ListNode(5)
                .next = new ListNode(9);

        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;
        int carry = 0;
        while (list1 != null && list2 != null) {
            int x = list1 == null ? 0 : list1.val;
            int y = list2 == null ? 0 : list2.val;

            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (list1 != null) {
                list1 = list1.next;
            }
            if (list2 != null) {
                list2 = list2.next;
            }
        }
        if (carry == 1) {
            listNode.next = new ListNode(carry);
        }
        System.out.println(listNode.next);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
