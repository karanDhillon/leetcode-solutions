class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
      if (root == null) return false
      
      return dfs(root, 0, targetSum)
    }
    
    fun dfs(
      root: TreeNode?,
      runningSum: Int,
      targetSum: Int
    ): Boolean {
      if (root == null) return false
      if (root.left == null && root.right == null && runningSum + root.`val` == targetSum) return true
      
      return dfs(root.left, runningSum + root.`val`, targetSum) || dfs(root.right, runningSum + root.`val`, targetSum)
    }
}