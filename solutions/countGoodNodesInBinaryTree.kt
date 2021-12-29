class Solution {
  var counter = 0
  
  fun goodNodes(root: TreeNode?): Int {
    isGoodNode(root, -10001)
    
    return counter
  }
  
  fun isGoodNode(root: TreeNode?,max: Int) {
    if (root == null) return
    
    if (root.`val` >= max) {
      counter++
      isGoodNode(root.left, root.`val`)
      isGoodNode(root.right, root.`val`)
    } else {
      isGoodNode(root.left, max)
      isGoodNode(root.right, max)
    }
  }
}