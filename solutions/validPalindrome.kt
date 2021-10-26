class Solution {
    fun isPalindrome(s: String): Boolean {
        val string = s.replace(Regex("[^A-Za-z0-9]"), "").toLowerCase()

        var begin = 0
        var end = string.length - 1
        var flag = true

        while (begin < end) {
            if (string.toCharArray()[begin] != string.toCharArray()[end]) flag = false

            ++begin
            --end
        }

        return flag
    }
}