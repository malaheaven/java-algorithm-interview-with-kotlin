package linkedlist;

public class SwapNodesInPairs {

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

    public ListNode swapPairs(ListNode head) {
        ListNode node = head;

        while (node != null && node.next != null) {
            int temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;

            node = node.next.next;

        }
        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        // 값을 계산할 임시 노드 선언
        ListNode node = new ListNode(0);

        // 임시 노드를 첫 번째 노드로 선언
        ListNode root = node;

        // 다음 노드는 첫 번째 노드로 지정
        node.next = head;

        // 다음 노드와 다음 다음 노드가 있으면 반복
        while (node.next != null && node.next.next != null) {

            // a는 다음 노드
            ListNode a = node.next;

            // b는 다음 다음 노드
            ListNode b = node.next.next;

            // 위치 변경
            a.next = b.next;
            node.next = b;
            node.next.next = a;

            // 두 칸 앞으로 이동
            node = node.next.next;
        }

        //  첫 번째 노드는 임시 노드이므로 그다음부터 결과로 리턴
        return root.next;
    }

    public ListNode swapPairs3(ListNode head) {
        // 현재 노드와 다음 노드가 있으면 반복
        if (head != null && head.next != null) {
            //  다음 노드 선언
            ListNode p = head.next;

            // 다음 다음 노드를 파라미터로 전달하고 스왑된 값을 리턴 받음
            head.next = swapPairs3(head.next.next);

            // 다음 다음 노드는 현재 노드로 지정
            p.next = head;

            return p;

        }
        return head;
    }

    public static void main(String[] args) {


        ListNode list3 = new ListNode(4);
        ListNode list2 = new ListNode(3, list3);
        ListNode list1 = new ListNode(2, list2);
        ListNode head = new ListNode(1, list1);

        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        System.out.println(swapNodesInPairs.swapPairs3(head));
    }
}
