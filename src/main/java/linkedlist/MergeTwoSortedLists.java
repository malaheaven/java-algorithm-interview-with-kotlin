package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists {


    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();

        for (ListNode node = list1; node != null; node = node.next) {
            list.add(node.val);
        }

        for (ListNode node = list2; node != null; node = node.next) {
            list.add(node.val);
        }

        if (list.isEmpty()) {
            return null;
        }

        list.sort(Integer::compareTo);

        ListNode head = new ListNode(list.get(0));
        ListNode current = head;

        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        // 두 노드 중 한쪽이 null이면 null이 아닌 노드를 리턴
        if (list1 == null) return list2;
        if (list2 == null) return list1;


        // list2가 더 크면 list1에 재귀 호출 결과를 엮고 list1을 리턴
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
            // list1이 더 크거나 같으면 list2에 재귀 호출 결과를 엮고 list2를 리턴
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


    public static void main(String[] args) {

        ListNode list1Node2 = new ListNode(4);
        ListNode list1Node1 = new ListNode(2, list1Node2);
        ListNode list1 = new ListNode(1, list1Node1);


        ListNode list2Node2 = new ListNode(4);
        ListNode list2Node1 = new ListNode(3, list2Node2);
        ListNode list2 = new ListNode(1, list2Node1);

        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        System.out.println(solution.mergeTwoLists2(list1, list2));
    }
}
