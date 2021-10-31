class Solution {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        val list = ArrayList<Int>()
        var sum = 0
        
        dfs(root, list)
        
        list.forEach {
            if (it >= low && it <= high) sum += it
        }
        
        return sum
    }
    
    fun dfs(node: TreeNode?, output: ArrayList<Int>) {
        if (node == null) return
        else {
            node.left?.let { dfs(it, output) }
            output.add(node.`val`)
            node.right?.let { dfs(it, output) }
        }
    }
}