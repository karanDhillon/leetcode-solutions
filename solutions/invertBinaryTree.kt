class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
      if (root == null) return null
      
      dfs(root)
      
      return root
    }
    
    fun dfs(node: TreeNode?) {
      if (node == null) return
      
      val leftNode = node.left
      
      node.left = node.right
      node.right = leftNode
      
      dfs(node.left)
      dfs(node.right)
    }
}