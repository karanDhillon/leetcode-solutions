class Solution {
    fun maxDepth(root: Node?): Int {
        var output = 0
        val queue = LinkedList<Node>()

        return if (root == null) output
        else {
            queue.offer(root)

            while (queue.isNotEmpty()) {
                for (i in 0 until queue.size) {
                    val polled = queue.poll()
                    polled.children.forEach { child -> child?.let { queue.offer(it) } }
                }
                ++output
            }

            output
        }
    }
}