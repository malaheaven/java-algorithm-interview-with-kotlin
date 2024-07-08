package linkedlist;

import java.util.*;

public class PalindromeLinkedList {

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
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        Deque<Integer> deque = new LinkedList<>();

        for (ListNode node = head; node != null; node = node.next) {
            deque.push(node.val);
        }

        while (!deque.isEmpty() && deque.size() > 1) {

            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        // 주의: 스택을 이렇게 선언하면 안 됨.
        Stack<Integer> stack = new Stack<>();

        // 연결 리스트를 스택에 삽입
        ListNode node = head;
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }

        // 연결 리스트가 모두 빌 때까지 비교
        while (head != null) {

            // 연결 리스트와 스택에서 추출한 값을 비교해 팰린드롬 판별
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    public boolean isPalindrome3(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // 빠른 러너가 끝까지 갈 때까지 느린 러너와 함께 진행
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 홀수 개일 때 느린 러너가 한 칸 더 앞으로 가도록 처리
        if (fast != null) {
            slow = slow.next;
        }

        // 중간에 도달한 느린 러너를 기준으로 하여 역순 연결 리스트를 만든다.
        ListNode rev = null;

        while (slow != null) {
            // 느린 러너로 역순 연결 리스트 rev를 만들어나간다.
            ListNode next = slow.next;
            slow.next = rev;
            rev = slow;
            slow = next;
        }


        // rev 연결리스트를 끝까지 이동하여 비교
        while (rev != null) {
            // 역숙 연결 리스트 rev와 기존 연결 리스트 head를 차례대로 비교
            if (rev.val != head.val) {
                return false;
            }
            rev = rev.next;
            head = head.next;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode(1);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

//        ListNode node3 = new ListNode(1);
//        ListNode node2 = new ListNode(0, node3);
//        ListNode head = new ListNode(1, node2);

        PalindromeLinkedList solution = new PalindromeLinkedList();
        System.out.println(solution.isPalindrome3(head));
    }
}
