//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 8738 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> l1c = new LinkedList<>();
        LinkedList<Integer> l2c = new LinkedList<>();
        LinkedList<Integer> sum = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            if (l1 != null) {
                l1c.add(l1.val);
                if (l1.next != null) {
                    l1 = l1.next;
                } else {
                    l1 = null;
                }
            }

            if (l2 != null) {
                l2c.add(l2.val);
                if (l2.next != null) {
                    l2 = l2.next;
                } else {
                    l2 = null;
                }
            }
        }

        for (int i = 0; i < Math.max(l1c.size(), l2c.size()); i++) {
            int num1 = 0;
            int num2 = 0;
            if (l1c.size() > i) {
                num1 = l1c.get(i);
            }
            if (l2c.size() > i) {
                num2 = l2c.get(i);
            }
            sum.add(num1 + num2);
        }

        ListNode sumList = new ListNode();
        ListNode res = sumList;
        for (int i = 0; i < sum.size(); i++) {
            int i1 = sum.get(i);

            if (i1 >= 10) {
                sum.add(i, i1 % 10);
                sum.remove(i + 1);
                if (i + 1 < sum.size()) {
                    sum.add(i + 1, sum.get(i + 1) + i1 / 10);
                    sum.remove(i + 2);
                } else {
                    sum.add(i1 / 10);
                }
            }

            sumList.val = sum.get(i);

            if (i + 1 < sum.size()) {
                sumList.next = new ListNode();
                sumList = sumList.next;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
