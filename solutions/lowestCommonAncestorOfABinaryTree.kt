class Solution {
  var lca: TreeNode? = null
  
  fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    recurseTree(root, p, q)
    
    return lca
  }
  
  fun recurseTree(root: TreeNode?, p: TreeNode?, q: TreeNode?): Boolean {
    if (root == null) return false
    
    val left = if (recurseTree(root.left, p, q)) 1 else 0
    val right = if (recurseTree(root.right, p, q)) 1 else 0
    
    val mid = if (root.`val` == p!!.`val` || root.`val` == q!!.`val`) 1 else 0
    
    if (left + right + mid == 2) {
      lca = root
    }
    
    return left + right + mid > 0
  }
}