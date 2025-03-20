package impls.monoid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * A test class for [NonNegativeIntAdditionMonoid].
 */
class NonNegativeIntAdditionMonoidTest {
    private val monoid = NonNegativeIntAdditionMonoid()

    @Test
    fun `identity element test`() {
        // Arrange
        val element = 5

        // Act & Assert
        assertEquals(element, monoid.combine(element, monoid.identity()))
        assertEquals(element, monoid.combine(monoid.identity(), element))
    }

    @Test
    fun `associativity test`() {
        // Arrange
        val a = 3
        val b = 7
        val c = 9

        // Act & Assert
        assertEquals(
            monoid.combine(monoid.combine(a, b), c),
            monoid.combine(a, monoid.combine(b, c)),
        )
    }

    @Test
    fun `combine addition test`() {
        // Arrange
        val a = 2
        val b = 3

        // Act
        val result = monoid.combine(a, b)

        // Assert
        assertEquals(5, result)
    }

    @Test
    fun `combining with zero test`() {
        // Arrange
        val a = 10

        // Act & Assert
        assertEquals(a, monoid.combine(a, 0))
        assertEquals(a, monoid.combine(0, a))
    }

    @Test
    fun `combining with negative number should throw exception`() {
        // Arrange
        val a = -5
        val b = 10

        // Act & Assert
        val exception1 =
            assertThrows<IllegalArgumentException> {
                monoid.combine(a, b)
            }
        assertEquals("This monoid only accepts non-negative integers", exception1.message)

        val exception2 =
            assertThrows<IllegalArgumentException> {
                monoid.combine(b, a)
            }
        assertEquals("This monoid only accepts non-negative integers", exception2.message)
    }

    @Test
    fun `both inputs are negative should throw exception`() {
        // Arrange
        val a = -3
        val b = -8

        // Act & Assert
        val exception =
            assertThrows<IllegalArgumentException> {
                monoid.combine(a, b)
            }
        assertEquals("This monoid only accepts non-negative integers", exception.message)
    }
}
