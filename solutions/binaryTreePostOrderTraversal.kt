class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val stack = Stack<TreeNode>()
        val output = LinkedList<Int>()

        return if (root == null) output
        else {
            stack.push(root)

            while (stack.isNotEmpty()) {
                val popped = stack.pop()
                output.addFirst(popped.`val`)
                popped.left?.let { stack.push(it) }
                popped.right?.let { stack.push(it) }
            }

            output
        }
    }
}