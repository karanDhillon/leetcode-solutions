class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
      if (p == null && q == null) return true
      if (p == null || q == null) return false
      
      return if (p.`val` == q.`val`) {
        isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
      }
      else false
    }
}