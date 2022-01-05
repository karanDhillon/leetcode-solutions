class Solution {
  var lca: Node? = null
  
    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
      val root = findRootNode(p)
      
      searchTree(root, p!!, q!!)
      
      return lca
    }
    
    fun searchTree(
      node: Node?,
      p: Node,
      q: Node
    ): Boolean {
      if (node == null) return false
      
      val n = if (
        node.`val` == p.`val` || 
        node.`val` == q.`val`
      ) 1 else 0
      val l = if (searchTree(node.left, p, q)) 1 else 0
      val r = if (searchTree(node.right, p, q)) 1 else 0
      
      if (n + l + r == 2) {
        lca = node
      }
      
      return n + l + r > 0
    }
    
    fun findRootNode(node: Node?): Node? {
      if (node == null) return null
      if (node?.parent == null) return node
  
      return findRootNode(node.parent)
    }
}