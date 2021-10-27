class Solution {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val output = ArrayList<String>()

        if (root == null) return output

        dfs(root, "${root.`val`}" , output)

        return output
    }

    fun dfs(
        node: TreeNode,
        path: String,
        output: ArrayList<String>
    ) {
        if (node.left == null && node.right == null) { output.add(path) }
        node.left?.let { dfs(it, path + "->${it.`val`}", output) }
        node.right?.let { dfs(it, path + "->${it.`val`}", output) }
    }
}