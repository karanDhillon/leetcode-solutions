class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
      val pq = PriorityQueue<Int>()
      
      nums.forEach { num ->
        pq.offer(num)
        
        if (pq.size > k) { pq.poll() }
      }
      
      return pq.poll()
    }
}