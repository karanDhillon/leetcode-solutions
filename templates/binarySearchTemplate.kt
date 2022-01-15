/*
* l and r when defined as 0 and nums.size - 1 respectively gaurantees that target values exists somwhere,
* including the boundaries.
*
* If we cannot gaurantee that target value will exist in [0, nums.size - 1], we can return l
* as long as we use while (l <= r)
*/

fun bs(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size - 1

    while (l <= r) { // worst case, there's only one element left in the range.
        val m = l + (r - l) / 2

        when {
            nums[m] < target -> l = m + 1
            target < nums[m] -> r = m - 1
            else -> return m
        }
    }

    return l // If we can gaurantee that value will lie in [0, nums.size - 1], we can return -1 as well.
}