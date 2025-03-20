package impls.semigroup

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * A test class for [LeftZeroBand].
 */
class LeftZeroBandTest {
    @Test
    fun integer() {
        // Arrange
        val target = LeftZeroBand<Int>()
        val a = 1
        val b = 2

        // Act
        val result = target.combine(a, b)

        // Assert
        assertEquals(a, result)
    }

    @Test
    fun string() {
        // Arrange
        val target = LeftZeroBand<String>()
        val a = "hello"
        val b = "world"

        // Act
        val result = target.combine(a, b)

        // Assert
        assertEquals(a, result)
    }

    @Test
    fun nullable() {
        // Arrange
        val target = LeftZeroBand<String?>()
        val a: String? = null
        val b = "world"

        // Act
        val result = target.combine(a, b)

        // Assert
        assertEquals(a, result)
    }

    @Test
    fun multipleCombine() {
        // Arrange
        val target = LeftZeroBand<Int>()
        val a = 7
        val b = 42
        val c = 99

        // Act
        val result = target.combine(target.combine(a, b), c)

        // Assert
        assertEquals(a, result)
    }

    @Test
    fun multipleCombine2() {
        // Arrange
        val target = LeftZeroBand<Int>()
        val a = 7
        val b = 42
        val c = 99

        // Act
        val result = target.combine(a, b, c)

        // Assert
        assertEquals(a, result)
    }
}
