class Solution {
    fun levelOrder(root: Node?): List<List<Int>> {
        val queue = LinkedList<Node>()
        val output = ArrayList<List<Int>>()

        return if (root == null) output
        else {
            queue.add(root)

            while (queue.isNotEmpty()) {
                val list = ArrayList<Int>()

                for (i in 0 until queue.size) {
                    val polled = queue.poll()
                    list.add(polled.`val`)
                    polled.children.forEach { childNode -> childNode?.let { queue.add(it) } }
                }

                output.add(list)
            }

            output
        }
    }
}