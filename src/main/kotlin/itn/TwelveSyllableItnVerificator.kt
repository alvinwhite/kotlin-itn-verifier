package itn

import itn.exceptions.InvalidItnException

class TwelveSyllableItnVerificator : ITNVerificator {
    private val elevenSyllableCoefficientList: List<Int> = listOf(7, 2, 4, 10, 3, 5, 9, 4, 6, 8, 0)
    private val twelveSyllableCoefficientList: List<Int> = listOf(3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8, 0)

    override fun verify(itn: String): Boolean {
        validate(itn)

        val elevenSyllableAppliedCoefficientsSum: Int = getSumOfAppliedItnCoefficients(
            itn.slice(0..10),
            elevenSyllableCoefficientList
        )
        val elevenSyllableControlNumber = calculateItnReminder(elevenSyllableAppliedCoefficientsSum)

        val twelveSyllableAppliedCoefficientsSum: Int = getSumOfAppliedItnCoefficients(
            itn,
            twelveSyllableCoefficientList
        )
        val twelveSyllableControlNumber = calculateItnReminder(twelveSyllableAppliedCoefficientsSum)

        val eleventhItnSyllable = itn[10].toString().toInt()
        val twelfthItnSyllable = itn[11].toString().toInt()

        if (
            elevenSyllableControlNumber == eleventhItnSyllable
            && twelveSyllableControlNumber == twelfthItnSyllable
        ) {
            return true;
        }

        return false
    }

    private fun validate(itn: String) {
        if (itn.length != 12) {
            throw InvalidItnException("Length of ITN should be equal to 12")
        }
    }
}