package itn

import itn.exceptions.UnsupportedItnException

class ItnVerificatorFactory {
    companion object {
        fun getVerificator(itnLength: Int): ITNVerificator {
            return when (itnLength) {
                10 -> TenSyllableItnVerificator()
                12 -> TwelveSyllableItnVerificator()
                else -> {
                    throw UnsupportedItnException("Cannot create ITN verificator for given ITN")
                }
            }
        }
    }
}