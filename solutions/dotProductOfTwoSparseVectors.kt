class SparseVector(val nums: IntArray) {
  val nonZero = HashSet<Int>()
  
  init {
    nums.forEachIndexed { index, num ->
      if (num != 0) nonZero.add(index)
    }
  }
  
    fun dotProduct(vec: SparseVector): Int {
      var sum = 0
      
      nonZero.forEach { nonZeroIndex ->
        sum += nums[nonZeroIndex] * vec.nums[nonZeroIndex]
      }

      return sum
    }
}