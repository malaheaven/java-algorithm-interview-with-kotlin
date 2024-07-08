package linkedlist

class PalindromeLinkedListKt {

    fun isPalindrome(head: ListNodeKt?): Boolean {
        val deque = ArrayDeque<Int>()

        // 연결 리스트를 데크에 삽입
        var node = head

        while (node != null) {
            deque.add(node.`val`)
            node = node.next
        }

        // 데크가 모두 비거나(짝수 개일 때) 1개 이하(홀수 개일 때)가 될 떄까지 비교ㅛ
        while (!deque.isEmpty() && deque.size > 1) {
            // 데크의 양 끝을 추출해 팰린드롬 여부 확인
            if (deque.removeFirst() !== deque.removeLast()) {
                return false
            }
        }
        return true
    }

}

class ListNodeKt(var `val`: Int) {
    var next: ListNodeKt? = null
}

fun main() {

    val node5 = ListNodeKt(1)
    val node4 = ListNodeKt(2)
    val node3 = ListNodeKt(3)
    val node2 = ListNodeKt(2)
    val head = ListNodeKt(1)


    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    val solution = PalindromeLinkedListKt()
    println(solution.isPalindrome(head))
}
