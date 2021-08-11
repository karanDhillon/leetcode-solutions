class Solution {
    fun searchInput(nums: IntArray, target: Int): Int {
        return binarySearch(nums, 0, nums.size - 1, target)
    }

    fun binarySearch(
        array: IntArray,
        left: Int,
        right: Int,
        target: Int
    ): Int {
        if (left >= right) {
            return if (array[left] == target) left
            else if (array[left] > target) left
            else left + 1
        }

        val mid = (left + right)/2

        return if (array[mid] > target) binarySearch(array, left, mid - 1, target)
        else if (array[mid] < target) binarySearch(array, mid + 1, right, target)
        else mid
}