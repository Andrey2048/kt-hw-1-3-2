import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun comission_shouldNotTakeComissionMaestro() {
        val card: String = TYPE_MAESTRO
        val sum = 1000
        val payment = 60_000

        val result = comission(cardType = card, monthSum = sum, transfer = payment)

        assertEquals(0, result)
    }

    @Test
    fun comission_shouldTakeComissionMaestro() {
        val card: String = TYPE_MAESTRO
        val sum = 1000
        val payment = 80_000

        val result = comission(cardType = card, monthSum = sum, transfer = payment)

        assertEquals(500, result)
    }

    @Test
    fun comission_shouldBeLimitErrorMaestro() {
        val card: String = TYPE_MAESTRO
        val sum = 550_000
        val payment = 80_000

        val result = comission(cardType = card, monthSum = sum, transfer = payment)

        assertEquals(-1, result)
    }

    @Test
    fun comission_shouldNotTakeComissionMastercard() {
        val card: String = TYPE_MASTERCARD
        val sum = 10_000
        val payment = 60_000

        val result = comission(cardType = card, monthSum = sum, transfer = payment)

        assertEquals(0, result)
    }

    @Test
    fun comission_shouldTakeComissionMastercard() {
        val card: String = TYPE_MASTERCARD
        val sum = 20_000
        val payment = 80_000

        val result = comission(cardType = card, monthSum = sum, transfer = payment)

        assertEquals(500, result)
    }

    @Test
    fun comission_shouldBeLimitErrorMastercard() {
        val card: String = TYPE_MASTERCARD
        val sum = 450_000
        val payment = 160_000

        val result = comission(cardType = card, monthSum = sum, transfer = payment)

        assertEquals(-1, result)
    }

    @Test
    fun comission_shouldBeTypeOfCardError() {
        val card = "Mastercard"
        val payment = 160_000

        val result = comission(cardType = card, transfer = payment)

        assertEquals(-2, result)
    }

    @Test
    fun comission_shouldBeMinComissionVisa() {
        val card: String = TYPE_VISA
        val sum = 1000
        val payment = 3_000

        val result = comission(cardType = card, monthSum = sum, transfer = payment)

        assertEquals(35, result)
    }

    @Test
    fun comission_shouldTakeComissionVisa() {
        val card: String = TYPE_VISA
        val sum = 1000
        val payment = 80_000

        val result = comission(cardType = card, monthSum = sum, transfer = payment)

        assertEquals(600, result)
    }

    @Test
    fun comission_shouldBeLimitErrorVisa() {
        val card: String = TYPE_VISA
        val sum = 550_000
        val payment = 80_000

        val result = comission(cardType = card, monthSum = sum, transfer = payment)

        assertEquals(-1, result)
    }
    @Test
    fun comission_shouldBeMinComissionMir() {
        val card: String = TYPE_MIR
        val sum = 1000
        val payment = 3_000

        val result = comission(cardType = card, monthSum = sum, transfer = payment)

        assertEquals(35, result)
    }

    @Test
    fun comission_shouldTakeComissionMir() {
        val card: String = TYPE_MIR
        val sum = 1000
        val payment = 100_000

        val result = comission(cardType = card, monthSum = sum, transfer = payment)

        assertEquals(750, result)
    }

    @Test
    fun comission_shouldBeLimitErrorMir() {
        val card: String = TYPE_MIR
        val sum = 550_000
        val payment = 80_000

        val result = comission(cardType = card, monthSum = sum, transfer = payment)

        assertEquals(-1, result)
    }

    @Test
    fun comission_shouldBeNoComissionVKPay() {
        val sum = 1000
        val payment = 3_000

        val result = comission(monthSum = sum, transfer = payment)

        assertEquals(100, result)
    }

    @Test
    fun comission_shouldBeMonthlyLimitErrorVKPay() {
        val card: String = TYPE_VK_PAY
        val payment = 6_000
        val sum = 35_000
        val result = comission(cardType = card, monthSum = sum, transfer = payment)

        assertEquals(-1, result)
    }

    @Test
    fun comission_shouldBeLimitErrorVKPay() {
        val payment = 16_000
        val result = comission(transfer = payment)
        assertEquals(-1, result)
    }
}