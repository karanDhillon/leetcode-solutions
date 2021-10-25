class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var sortedArrayPointer = 0
        var currentPointer = 0

        while (currentPointer < nums.size) {
            if (nums[sortedArrayPointer] == nums[currentPointer]) {
                currentPointer++
            } else {
                sortedArrayPointer++
                nums[sortedArrayPointer] = nums[currentPointer]
                currentPointer++
            }
        }

        return sortedArrayPointer + 1
    }
}