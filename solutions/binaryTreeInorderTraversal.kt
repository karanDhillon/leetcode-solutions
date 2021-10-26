class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val stack = Stack<TreeNode>()
        val output = LinkedList<Int>()
        var current: TreeNode? = null

        return if (root == null) output
        else {
            current = root

            while (current != null || stack.isNotEmpty()) {
                while (current != null) {
                    stack.push(current)
                    current = current.left
                }

                val popped = stack.pop()
                output.add(popped.`val`)
                current = popped.right
            }

            output
        }
    }
}