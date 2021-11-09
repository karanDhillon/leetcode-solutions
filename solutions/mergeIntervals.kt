class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val output = ArrayList<IntArray>()

        intervals.sortWith(compareBy { it[0] })

        intervals.forEach { interval ->
            if (output.isEmpty() || output.last()[1] < interval[0])
                output.add(interval)
            else
                output.last()[1] = maxOf(output.last()[1], interval[1])
        }

        return output.toTypedArray()
    }
}