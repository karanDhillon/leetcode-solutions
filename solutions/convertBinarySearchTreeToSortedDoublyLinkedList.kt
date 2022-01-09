class Solution {
  var first: Node? = null
  var last: Node? = null
  
    fun treeToDoublyList(root:Node?): Node? {
      helper(root)
      
      first?.left = last
      last?.right = first
      
      return first
    }
    
    fun helper(node: Node?) {
      if (node == null) return
      
      helper(node.left)

      if (first == null) { first = node }
      node.left = last
      last?.right = node
      last = node  
      
      helper(node.right)
    }
}