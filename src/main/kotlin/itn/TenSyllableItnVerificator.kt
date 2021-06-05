package itn

import itn.exceptions.InvalidItnException

class TenSyllableItnVerificator : ITNVerificator {
    private val coefficientList: List<Int> = listOf(2, 4, 10, 3, 5, 9, 4, 6, 8, 0)

    override fun verify(itn: String): Boolean {
        validate(itn)

        val appliedCoefficientsSum: Int = getSumOfAppliedItnCoefficients(itn, coefficientList)
        val controlNumber = calculateItnReminder(appliedCoefficientsSum)

        val lastItnSyllable = itn.last().toString().toInt()

        if (lastItnSyllable == controlNumber) {
            return true
        }

        return false
    }

    private fun validate(itn: String) {
        if (itn.length != 10) {
            throw InvalidItnException("Length of ITN should be equal to 10")
        }
    }
}