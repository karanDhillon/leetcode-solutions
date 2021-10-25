class Solution {
    fun addBinary(a: String, b: String): String {
        val stringBuilder = StringBuilder()
        var i = a.length - 1
        var j = b.length - 1
        var carry = 0

        while (i >= 0 || j >= 0) {
            var sum = carry
            if (i >= 0) sum += Character.getNumericValue(a.toCharArray()[i])
            if (j >= 0) sum += Character.getNumericValue(b.toCharArray()[j])

            stringBuilder.append(sum % 2)
            carry = sum / 2

            i--
            j--
        }

        if (carry != 0) stringBuilder.append(carry)

        return stringBuilder.reverse().toString()
    }
}