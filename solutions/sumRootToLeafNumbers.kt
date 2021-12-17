class Solution {
    fun sumNumbers(root: TreeNode?): Int {    
      return dfs(root, 0)
    }
    
    fun dfs(current: TreeNode?, sum: Int): Int {
      if (current == null) return 0
      if (current.left == null && current.right == null) return sum * 10 + current.`val`
      
      return dfs(current.left, sum * 10 + current.`val`) + dfs(current.right, sum * 10 + current.`val`)
    }
}