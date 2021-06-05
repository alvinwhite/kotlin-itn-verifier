import itn.ITNVerificator
import itn.ItnVerificatorFactory

fun main(args: Array<String>) {
    val itn: String = args[0]
    val verificator: ITNVerificator = ItnVerificatorFactory.getVerificator(itn.length)
    val itnIsValid = verificator.verify(itn)

    print("ITN $itn ${if (itnIsValid) "is valid" else "is invalid"}")
}