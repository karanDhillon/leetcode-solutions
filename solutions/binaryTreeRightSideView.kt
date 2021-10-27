class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val output = ArrayList<Int>()
        val queue = LinkedList<TreeNode>()

        return if (root == null) output
        else {
            queue.offer(root)

            while (queue.isNotEmpty()) {
                val queueSize = queue.size-1
                for (i in 0..queueSize) {
                    val polled = queue.poll()

                    if (i == queueSize) output.add(polled.`val`)

                    polled.left?.let { queue.add(it) }
                    polled.right?.let { queue.add(it) }
                }
            }

            output
        }
    }
}