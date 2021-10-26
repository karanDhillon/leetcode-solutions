class Solution {
    fun flatten(root: TreeNode?): Unit {
        val stack = Stack<TreeNode>()

        root?.let {
            stack.push(root)

            while (stack.isNotEmpty()) {
                val popped = stack.pop()
                popped.right?.let { stack.push(it) }
                popped.left?.let { stack.push(it) }

                if (stack.isNotEmpty()) {
                    popped.right = stack.peek()
                }

                popped.left = null
            }   
        }
    }
}