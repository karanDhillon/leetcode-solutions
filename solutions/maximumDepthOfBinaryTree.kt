class Solution {
  var treeDepth = 0
  
  fun maxDepth(root: TreeNode?): Int { 
    if (root == null) return 0
    
    helper(root, 1)
    
    return treeDepth
  }
  
  fun helper(node: TreeNode?, depthAtNode: Int) {
    if (node == null) return
    
    treeDepth = Math.max(treeDepth, depthAtNode)
    
    helper(node.left, depthAtNode + 1)
    helper(node.right, depthAtNode + 1)
  }
}