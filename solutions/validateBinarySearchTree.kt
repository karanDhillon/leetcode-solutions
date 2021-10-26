class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        val stack = Stack<TreeNode>()
        val output = ArrayList<Int>()
        var current: TreeNode?
        var flag = true

        return if (root == null) flag
        else {
            current = root

            while (current != null || stack.isNotEmpty()) {
                while (current != null) {
                    stack.push(current)
                    current = current.left
                }

                current = stack.pop()
                output.add(current.`val`)
                current = current.right
            }

            val array = output.toIntArray()
            for (i in 0..array.size-2) {
                if (array[i] >= array[i+1]) {
                    flag = false
                }
            }

            return flag
        }
    }
}