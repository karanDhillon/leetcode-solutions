class Solution {
    fun findLeaves(root: TreeNode?): List<List<Int>> {
      if (root == null) return emptyList()
      
      val output = ArrayList<ArrayList<Int>>()
      
      while (root?.left != null || root?.right != null) {
        val list = ArrayList<Int>()
        helper(root, list)
        output.add(list)
      }
      
      output.add(arrayListOf(root.`val`))
      
      return output
    }
    
    fun helper(node: TreeNode?, list: ArrayList<Int>): Boolean {
      if (node == null) return false
      if (node.left == null && node.right == null) {
        list.add(node.`val`)
        return true
      }
      
      val left = helper(node.left, list)
      val right = helper(node.right, list)
      
      if (left) { node.left = null }
      if (right) { node.right = null }
      
      return false
    }
}