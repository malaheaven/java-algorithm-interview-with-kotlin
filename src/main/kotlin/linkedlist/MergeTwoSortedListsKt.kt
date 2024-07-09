package linkedlist

class ListNodeKt2(var `val`: Int) {
    var next: ListNodeKt2? = null

    override fun toString(): String {
        return "ListNodeKt2(`val`=$`val`, next=$next)"
    }


}

class MergeTwoSortedListsKt {
    fun mergeTwoLists(list1: ListNodeKt2?, list2: ListNodeKt2?): ListNodeKt2? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        return if (list1.`val` < list2.`val`) {
            list1.next = mergeTwoLists(list1.next, list2)
            list1
        } else {
            list2.next = mergeTwoLists(list1, list2.next)
            list2
        }
    }
}


fun main() {

    val list1Node2 = ListNodeKt2(4)
    val list1Node1 = ListNodeKt2(2)
    val list1 = ListNodeKt2(1)

    list1Node1.next = list1Node2
    list1.next = list1Node1

    val list2Node2 = ListNodeKt2(4)
    val list2Node1 = ListNodeKt2(3)
    val list2 = ListNodeKt2(1)

    list2Node1.next = list2Node2
    list2.next = list2Node1

    val solution = MergeTwoSortedListsKt()
    println(solution.mergeTwoLists(list1, list2))
}
