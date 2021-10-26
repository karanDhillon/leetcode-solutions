class Solution {
    fun preorder(root: Node?): List<Int> {
        val stack = Stack<Node>()
        val output = ArrayList<Int>()

        return if (root == null) emptyList()
        else {
            stack.push(root)

            while (!stack.isEmpty()) {
                val popped = stack.pop()
                output.add(popped.`val`)
                popped.children.reversed().forEach { stack.push(it) }
            }

            output
        }
    }
}