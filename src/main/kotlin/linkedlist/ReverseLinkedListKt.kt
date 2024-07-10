package linkedlist

class ReverseLinkedListKt {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null


        override fun toString(): String {
            return "ListNode(`val`=$`val`, next=$next)"
        }
    }

    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null;
        var node = head;

        while (node != null) {

            val next = node.next

            node.next = prev

            prev = node

            node = next
        }
        return prev
    }
}

fun main() {
    val list4 = ReverseLinkedListKt.ListNode(5)
    val list3 = ReverseLinkedListKt.ListNode(4)
    val list2 = ReverseLinkedListKt.ListNode(3)
    val list1 = ReverseLinkedListKt.ListNode(2)
    val head = ReverseLinkedListKt.ListNode(1)


    head.next = list1
    list1.next = list2
    list2.next = list3
    list3.next = list4

    val solution = ReverseLinkedListKt()
    println(solution.reverseList(head))
}
