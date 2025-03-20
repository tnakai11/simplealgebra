package impls.monoid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * A test class for [IntAdditionMonoid].
 */
class IntAdditionMonoidTest {
    private val monoid = IntAdditionMonoid()

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
}
