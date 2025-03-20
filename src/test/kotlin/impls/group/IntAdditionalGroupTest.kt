package impls.group

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * A test class for [IntAdditionalGroup].
 */
class IntAdditionalGroupTest {
    private val group = IntAdditionalGroup()

    @Test
    fun `identity element test`() {
        // Arrange
        val element = 10

        // Act & Assert
        assertEquals(element, group.combine(element, group.identity()))
        assertEquals(element, group.combine(group.identity(), element))
    }

    @Test
    fun `associativity test`() {
        // Arrange
        val a = 5
        val b = -3
        val c = 8

        // Act & Assert
        assertEquals(
            group.combine(group.combine(a, b), c),
            group.combine(a, group.combine(b, c)),
        )
    }

    @Test
    fun `inverse element test`() {
        // Arrange
        val a = 7

        // Act & Assert
        assertEquals(group.identity(), group.combine(a, group.inverse(a)))
        assertEquals(group.identity(), group.combine(group.inverse(a), a))
    }

    @Test
    fun `basic addition test`() {
        // Arrange
        val a = 2
        val b = 3

        // Act
        val result = group.combine(a, b)

        // Assert
        assertEquals(5, result)
    }

    @Test
    fun `inverse of negative number test`() {
        // Arrange
        val a = -4

        // Act
        val inverse = group.inverse(a)

        // Assert
        assertEquals(4, inverse)
        assertEquals(group.identity(), group.combine(a, inverse))
    }

    @Test
    fun `combining zero with any element test`() {
        // Arrange
        val a = 15
        val zero = group.identity()

        // Act & Assert
        assertEquals(a, group.combine(a, zero))
        assertEquals(a, group.combine(zero, a))
    }

    @Test
    fun `combining an element with its inverse results in zero`() {
        // Arrange
        val a = 9

        // Act
        val result = group.combine(a, group.inverse(a))

        // Assert
        assertEquals(group.identity(), result)
    }
}
