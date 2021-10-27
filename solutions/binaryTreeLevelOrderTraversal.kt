class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val output = ArrayList<List<Int>>()
        val queue = LinkedList<TreeNode>()

        return if (root == null) output
        else {
            queue.add(root)

            while (queue.isNotEmpty()) {
                val list = ArrayList<Int>()

                for (i in 0 until queue.size) {
                    val polled = queue.remove()
                    list.add(polled.`val`)
                    polled.left?.let { queue.offer(it) }
                    polled.right?.let { queue.offer(it) }
                }

                output.add(list)
            }

            output
        }
    }
}