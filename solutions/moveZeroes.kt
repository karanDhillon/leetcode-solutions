class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        // sortZerosWithBubbleSort(nums)
        sortZerosWithIndex(nums)
    }
    
    fun sortZerosWithIndex(nums: IntArray): Unit {
        var index = 0
        
        for(i in 0 until nums.size) {
            if (nums[i] != 0)
                nums[index++] = nums[i]
        }
        
        for (i in index until nums.size) {
            nums[i] = 0
        }
    }
    
    fun sortZerosWithBubbleSort(nums: IntArray): Unit {
         // Applying Bubble Sort
        for (i in 0 until nums.size) {
            for (j in 0 until nums.size-1) {
                if (nums[j] == 0) {
                    nums[j] = nums[j+1]
                    nums[j+1] = 0
                }
            }
        }
    }
}