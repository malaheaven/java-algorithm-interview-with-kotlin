package linkedlist;

public class ReverseLinkedList {


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

    public ListNode reverse(ListNode node, ListNode prev) {

        // 현재 노드인 node가 널이면 리턴
        if (node == null) {
            return prev;
        }

        // 현재 노드와 다음 노드 미리 지정
        ListNode next = node.next;

        // 현재 노드의 다음으로 이전 노드 지정
        node.next = prev;

        // 다음 노드와 현재 노드를 파라미터로 하여 재귀 호출
        return reverse(next, node);
    }

    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode node = head;

        // 노드 끝으로 이동할 떄까지 순회
        while (node != null) {

            // 현재 노드의 다음 노드를 미리 지정
            ListNode next = node.next;

            // 현재 노드의 다음으로 이전 노드 지정
            node.next = prev;

            // 이전 노드는 현재 노드로 지정
            prev = node;

            // 미리 지정했던 다음 노드를 현재 노드로 변경
            node = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode head = new ListNode(1, listNode2);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        System.out.println(reverseLinkedList.reverseList2(head));
    }
}
