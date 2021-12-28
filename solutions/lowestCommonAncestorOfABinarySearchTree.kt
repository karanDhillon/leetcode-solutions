class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
      if (root == null || p == null || q == null) return root
      
      if (p.`val` < root.`val` && q.`val` < root.`val`) {
        return lowestCommonAncestor(root.left, p, q)
      } else if (p.`val` > root.`val` && q.`val` > root.`val`) {
        return lowestCommonAncestor(root.right, p, q)
      } else {
        return root
      }
    }
}