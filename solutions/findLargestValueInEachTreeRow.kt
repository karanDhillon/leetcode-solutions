class Solution {
    fun largestValues(root: TreeNode?): List<Int> {
      if (root == null) return emptyList()

      val output = ArrayList<Int>()
      
      val queue = LinkedList<TreeNode>()
      queue.offer(root)

      while (queue.isNotEmpty()) {
        val queueSize = queue.size
        var max = Int.MIN_VALUE
        
        for (i in 0 until queueSize) {
          val treeNode = queue.poll()
          
          max = Math.max(max, treeNode.`val`)
          
          treeNode.left?.let { queue.offer(it) }
          treeNode.right?.let { queue.offer(it) }
        }
        
        output.add(max)
      }
      
      return output
    }
}