package itn

interface ITNVerificator {
    fun verify(itn: String): Boolean

    fun getSumOfAppliedItnCoefficients(itn: String, coefficientList: List<Int>): Int {
        return itn
            .map { it.toString().toInt() }
            .toIntArray()
            .foldIndexed(0) { index, sum, itnNumber ->
                val coefficient = coefficientList[index]
                sum + (itnNumber * coefficient)
            }
    }

    fun calculateItnReminder(sum: Int): Int {
        var reminder = sum % 11

        if (reminder > 9) {
            reminder %= 10
        }

        return reminder
    }
}