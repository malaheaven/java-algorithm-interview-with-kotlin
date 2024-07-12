package linkedlist

class AddTwoNumbersKt {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null

        override fun toString(): String {
            return "ListNode(`val`=$`val`, next=$next)"
        }
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var sum = 0
        var carry = 0
        var remainder = 0

        var l1List = l1
        var l2List = l2

        var node = ListNode(0)
        val root = node

        while (l1List != null || l2List != null || carry != 0) {
            sum = 0

            if (l1List != null) {
                sum += l1List.`val`
                l1List = l1List.next
            }

            if (l2List != null) {
                sum += l2List.`val`
                l2List = l2List.next
            }

            remainder = (sum + carry) % 10
            carry = (sum + carry) / 10

            node.next = ListNode(remainder)
            node = node.next!!
        }
        return root.next
    }
}

fun main() {

    val l1num2 = AddTwoNumbersKt.ListNode(3)
    val l1num1 = AddTwoNumbersKt.ListNode(4)
    val l1 = AddTwoNumbersKt.ListNode(2)

    l1num1.next = l1num2
    l1.next = l1num1

    val l2num2 = AddTwoNumbersKt.ListNode(4)
    val l2num1 = AddTwoNumbersKt.ListNode(6)
    val l2 = AddTwoNumbersKt.ListNode(5)

    l2num1.next = l2num2
    l2.next = l2num1

    val solution = AddTwoNumbersKt()
    println(solution.addTwoNumbers(l1, l2))
}
