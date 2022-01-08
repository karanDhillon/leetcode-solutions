class Solution {
    fun connect(root: Node?): Node? {
      if (root == null) return null
      dfs(root)
      return root
    }
    
    fun dfs(node: Node?) {
      if (node == null) return
      
      node?.left?.next = node?.right
      node?.right?.next = node?.next?.left
      
      dfs(node?.left)
      dfs(node?.right)
    }
}