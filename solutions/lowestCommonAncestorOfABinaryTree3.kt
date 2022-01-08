class Solution {
    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
      var pNode = p
      var qNode = q
      
      var pd = findNodeDepth(p)
      var qd = findNodeDepth(q)
      
      while (pd > qd) {
        pNode = pNode?.parent
        --pd
      }
      
      while (qd > pd) {
        qNode = qNode?.parent
        --qd
      }
      
      while (pNode != qNode) {
        pNode = pNode?.parent
        qNode = qNode?.parent
      }
      
      return pNode
    }
    
    fun findNodeDepth(node: Node?): Int {
      var depth = 0
      var parent = node?.parent
      
      while (parent != null) {
        depth++
        parent = parent?.parent
      }
      
      return depth
    }
}