class Solution {
    fun search(nums: IntArray, target: Int): Int {    
        return bs(nums, 0, nums.size - 1, target)
    }
    
    fun bs(nums: IntArray, i: Int, j: Int, target: Int): Int {
        if(i > j) return -1
        else {
            return if(nums[(i+j)/2] == target) (i+j)/2
            else if(nums[(i+j)/2] < target) bs(nums, (i+j)/2 + 1, j, target)
            else bs(nums, i, (i+j)/2 - 1, target)
        }
    }
}