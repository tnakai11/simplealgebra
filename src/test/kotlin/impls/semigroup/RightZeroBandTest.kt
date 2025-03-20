package impls.semigroup

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * A test class for [RightZeroBand].
 */
class RightZeroBandTest {

    @Test
    fun integer() {
        // Arrange
        val target = RightZeroBand<Int>()
        val a = 1
        val b = 2

        // Act
        val result = target.combine(a, b)

        // Assert
        assertEquals(b, result)
    }

    @Test
    fun string() {
        // Arrange
        val target = RightZeroBand<String>()
        val a = "hello"
        val b = "world"

        // Act
        val result = target.combine(a, b)

        // Assert
        assertEquals(b, result)
    }

    @Test
    fun nullable() {
        // Arrange
        val target = RightZeroBand<String?>()
        val a: String? = null
        val b = "world"

        // Act
        val result = target.combine(a, b)

        // Assert
        assertEquals(b, result)
    }

    @Test
    fun multipleCombine() {
        // Arrange
        val target = RightZeroBand<Int>()
        val a = 7
        val b = 42
        val c = 99

        // Act
        val result = target.combine(target.combine(a, b), c)

        // Assert
        assertEquals(c, result)
    }

    @Test
    fun multipleCombine2() {
        // Arrange
        val target = RightZeroBand<Int>()
        val a = 7
        val b = 42
        val c = 99

        // Act
        val result = target.combine(a, b, c)

        // Assert
        assertEquals(c, result)
    }
}