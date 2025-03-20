package impls.semigroup

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * A test class for [RectangularBandTest].
 */
class RectangularBandTest {

    @Test
    fun integer() {
        // Arrange
        val target = RectangularBand<Int, Int>()
        val a = 1 to 100
        val b = 2 to 200

        // Act
        val result = target.combine(a, b)

        // Assert
        val expected = a.first to b.second
        assertEquals(expected, result)
    }

    @Test
    fun string() {
        // Arrange
        val target = RectangularBand<String, String>()
        val a = "hello" to "Python"
        val b = "goodbye" to "Kotlin"

        // Act
        val result = target.combine(a, b)

        // Assert
        val expected = a.first to b.second
        assertEquals(expected, result)
    }

    @Test
    fun nullable() {
        // Arrange
        val target = RectangularBand<Int?, String?>()
        val a: Pair<Int?, String?> = null to null
        val b = 100 to "Kotlin"

        // Act
        val result = target.combine(a, b)

        // Assert
        val expected = a.first to b.second
        assertEquals(expected, result)
    }

    @Test
    fun multipleCombine() {
        // Arrange
        val target = RectangularBand<Int, Int>()
        val a = 7 to 200
        val b = 42 to 500
        val c = 99 to 100

        // Act
        val result = target.combine(target.combine(a, b), c)

        // Assert
        val expected = a.first to c.second
        assertEquals(expected, result)
    }

    @Test
    fun multipleCombine2() {
        // Arrange
        val target = RectangularBand<Int, Int>()
        val a = 7 to 200
        val b = 42 to 500
        val c = 99 to 100

        // Act
        val result = target.combine(a, b, c)

        // Assert
        val expected = a.first to c.second
        assertEquals(expected, result)
    }
}
