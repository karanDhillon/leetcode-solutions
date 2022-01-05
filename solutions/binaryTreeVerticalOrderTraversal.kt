class Solution {
    fun verticalOrder(root: TreeNode?): List<List<Int>> {
      if (root == null) return emptyList()
      
      val map = HashMap<Int, ArrayList<Int>>()
      val queue = LinkedList<Pair<TreeNode, Int>>()
      queue.offer(Pair(root, 0))
      
      while (queue.isNotEmpty()) {
        val polled = queue.poll()
        val node = polled.first
        val order = polled.second
        
        if (map.contains(order)) map.get(order)!!.add(node.`val`)
        else map.put(order, arrayListOf(node.`val`))
        
        node.left?.let { queue.offer(Pair(it, order - 1)) }
        node.right?.let { queue.offer(Pair(it, order + 1)) }
      }
      
      val output = ArrayList<ArrayList<Int>>()
        
      map.toSortedMap().entries.forEach { output.add(it.value) }
      
      return output
    }
}