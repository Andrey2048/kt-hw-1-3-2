import kotlin.math.max

const val TYPE_MASTERCARD = "MasterCard"
const val TYPE_MAESTRO = "Maestro"
const val TYPE_VISA = "Visa"
const val TYPE_MIR = "Mir"
const val TYPE_VK_PAY = "VK_Pay"
const val LIMIT_MONTH_CARD = 600_000
const val LIMIT_MONTH_VK_PAY = 40_000
const val LIMIT_ONETIME_TRANSFER_VK_PAY = 15_000
const val ERROR_LIMIT = -1
const val ERROR_TYPE = -2

fun main() {
    println(comission(TYPE_MASTERCARD, 15_000, 200_000))
    println(comission(TYPE_VK_PAY, 15_000, 200_000))
}

fun comission(cardType: String = TYPE_VK_PAY, monthSum: Int = 0, transfer: Int): Int {

    return when (cardType) {
        TYPE_MAESTRO, TYPE_MASTERCARD -> {
            if ((monthSum + transfer) < LIMIT_MONTH_CARD) {
                if (transfer <= 75_000) 0
                else 20 + (0.006 * transfer).toInt()
            } else ERROR_LIMIT
        }

        TYPE_VISA, TYPE_MIR -> if ((monthSum + transfer) < LIMIT_MONTH_CARD)
            max(35, (transfer * 0.0075).toInt())
        else ERROR_LIMIT

        TYPE_VK_PAY -> {
            if (((monthSum + transfer) < LIMIT_MONTH_VK_PAY) and (transfer < LIMIT_ONETIME_TRANSFER_VK_PAY)) 0
            else ERROR_LIMIT
        }

        else -> ERROR_TYPE
    }

}