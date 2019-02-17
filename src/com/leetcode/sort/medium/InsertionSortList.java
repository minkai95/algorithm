package com.leetcode.sort.medium;

/**
 * 【对链表进行插入排序】
 *
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
 public class InsertionSortList {
     public static void main(String[] args) {
         ListNode l1 = new ListNode(-1);
         ListNode l2 = new ListNode(5);
         ListNode l3 = new ListNode(3);
         ListNode l4 = new ListNode(4);
         ListNode l5 = new ListNode(0);
         l1.next = l2;
         l2.next = l3;
         l3.next = l4;
         l4.next = l5;
         ListNode ll = insertionSortList(l1);
     }
     private static ListNode insertionSortList(ListNode head) {
         if (head==null || head.next==null){
             return head;
         }
         ListNode tar = head;
         ListNode tarPre = null;
         ListNode now = head.next;
         ListNode nowPre = head;
         while (now != null){
             if (!now.equals(tar)) {
                 if (now.val < tar.val) {
                     nowPre.next = now.next;
                     now.next = tar;
                     if (tarPre != null) {
                         tarPre.next = now;
                     } else {
                         head = now;
                     }
                     now = nowPre.next;
                     tar = head;
                     tarPre = null;
                 } else {
                     tarPre = tar;
                     tar = tar.next;
                 }
             }else {
                 nowPre = now;
                 now = now.next;
                 tar = head;
                 tarPre = null;
             }
         }
         return head;
     }
}