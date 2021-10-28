class Solution {
    fun closestValue(root: TreeNode?, target: Double): Int {    
        return findClosestToTarget(inOrderTraversal(root), target)
    }
    
    fun findClosestToTarget(list: List<Int>, target: Double): Int {
        var closestToTarget = list.first()
        var minDistance = Math.abs(closestToTarget - target)

        for (i in 1 until list.size) {
            val distance = Math.abs(list[i] - target)

            if (distance < minDistance) {
                closestToTarget = list[i]
                minDistance = distance
            }
        }
        
        return closestToTarget
    }
    
    fun inOrderTraversal(root: TreeNode?): List<Int> {
        val output = ArrayList<Int>()
        val stack = Stack<TreeNode>()
        
        return if (root == null) output
        else {
            var current = root
            
            while (current != null || stack.isNotEmpty()) {
                while (current != null) {
                    stack.push(current)
                    current = current.left
                }
                
                val popped = stack.pop()
                output.add(popped.`val`)
                current = popped.right
            }
            
            output
        }
    }
}