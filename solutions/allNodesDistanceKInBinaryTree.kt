/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
      if (target == null || root == null) return arrayListOf()
      
      var level = 0
      
      val nodeToParentHashMap = createNodeToParentHashMap(root)
      val visited = HashSet<TreeNode>()
      val queue = LinkedList<TreeNode>().apply { add(target) }
      
      while (level < k) {
        val queueSize = queue.size
        
        for (i in 0 until queueSize) {
          val node = queue.poll()
          
          visited.add(node)

          node.left?.let { if (!visited.contains(it)) queue.add(it) }
          node.right?.let { if (!visited.contains(it)) queue.add(it) }
          nodeToParentHashMap.get(node)?.let { if (!visited.contains(it)) queue.add(it) }
        }

        level++
      }
      
      return convertListOfNodeToListOfInt(queue)
    }
    
    fun createNodeToParentHashMap(root: TreeNode): HashMap<TreeNode, TreeNode?> {
      val map = HashMap<TreeNode, TreeNode?>()
      val stack = Stack<TreeNode>().apply { push(root) }
      
      while (stack.isNotEmpty()) {
        val node = stack.pop()
        
        node.right?.let { 
          stack.push(it) 
          map.put(it, node)
        }
        node.left?.let { 
          stack.push(it) 
          map.put(it, node)
        }
      }
      
      return map
    }
    
    fun convertListOfNodeToListOfInt(queue: LinkedList<TreeNode>): List<Int> {
      val arrayList = ArrayList<Int>()
      
      while (queue.isNotEmpty())
        queue.poll()?.let { arrayList.add(it.`val`) }
      
      return arrayList
    }
}