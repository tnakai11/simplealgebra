package impls.group

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * A test class for [DoubleAdditionalGroup].
 */
class DoubleAdditionalGroupTest {
    private val group = DoubleAdditionalGroup()

    @Test
    fun `identity element test`() {
        // Arrange
        val element = 10.5

        // Act & Assert
        assertEquals(element, group.combine(element, group.identity()), 1e-6)
        assertEquals(element, group.combine(group.identity(), element), 1e-6)
    }

    @Test
    fun `associativity test`() {
        // Arrange
        val a = 5.5
        val b = -3.3
        val c = 8.8

        // Act & Assert
        assertEquals(
            group.combine(group.combine(a, b), c),
            group.combine(a, group.combine(b, c)),
            1e-6,
        )
    }

    @Test
    fun `inverse element test`() {
        // Arrange
        val a = 7.7

        // Act & Assert
        assertEquals(group.identity(), group.combine(a, group.inverse(a)), 1e-6)
        assertEquals(group.identity(), group.combine(group.inverse(a), a), 1e-6)
    }

    @Test
    fun `basic addition test`() {
        // Arrange
        val a = 2.2
        val b = 3.3

        // Act
        val result = group.combine(a, b)

        // Assert
        assertEquals(5.5, result, 1e-6)
    }

    @Test
    fun `inverse of negative number test`() {
        // Arrange
        val a = -4.4

        // Act
        val inverse = group.inverse(a)

        // Assert
        assertEquals(4.4, inverse, 1e-6)
        assertEquals(group.identity(), group.combine(a, inverse), 1e-6)
    }

    @Test
    fun `combining zero with any element test`() {
        // Arrange
        val a = 15.5
        val zero = group.identity()

        // Act & Assert
        assertEquals(a, group.combine(a, zero), 1e-6)
        assertEquals(a, group.combine(zero, a), 1e-6)
    }

    @Test
    fun `combining an element with its inverse results in zero`() {
        // Arrange
        val a = 9.9

        // Act
        val result = group.combine(a, group.inverse(a))

        // Assert
        assertEquals(group.identity(), result, 1e-6)
    }
}
