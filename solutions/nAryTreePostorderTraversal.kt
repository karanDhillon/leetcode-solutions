class Solution {
    fun postorder(root: Node?): List<Int> {
        val stack = Stack<Node>()
        val output = LinkedList<Int>()

        return if (root == null) output
        else {
            stack.push(root)

            while (stack.isNotEmpty()) {
                val popped = stack.pop()
                output.addFirst(popped.`val`)
                popped.children.forEach { stack.push(it) }
            }

            output
        }
    }
}