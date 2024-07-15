package linkedlist

class SwapNodesInPairsKt {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null


        override fun toString(): String {
            return "ListNode(`val`=$`val`, next=$next)"
        }
    }

    fun swapPairs(head: ListNode?): ListNode? {

        if (head?.next != null) {
            val p = head.next

            head.next = swapPairs(head.next?.next)
            p?.next = head;
            return p
        }

        return head
    }
}

fun main() {

    val list3 = SwapNodesInPairsKt.ListNode(4)
    val list2 = SwapNodesInPairsKt.ListNode(3)
    val list1 = SwapNodesInPairsKt.ListNode(2)
    val head = SwapNodesInPairsKt.ListNode(1)

    list2.next = list3
    list1.next = list2
    head.next = list1

    val soluition = SwapNodesInPairsKt()
    println(soluition.swapPairs(head))
}
