package impls.monoid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * A test class for [StringAdditionMonoid].
 */
class StringAdditionMonoidTest {
    private val monoid = StringAdditionMonoid()

    @Test
    fun `identity element test`() {
        // Arrange
        val element = "Hello"

        // Act & Assert
        assertEquals(element, monoid.combine(element, monoid.identity()))
        assertEquals(element, monoid.combine(monoid.identity(), element))
    }

    @Test
    fun `associativity test`() {
        // Arrange
        val a = "Hello"
        val b = "World"
        val c = "!"

        // Act & Assert
        assertEquals(
            monoid.combine(monoid.combine(a, b), c),
            monoid.combine(a, monoid.combine(b, c)),
        )
    }

    @Test
    fun `combine concatenation test`() {
        // Arrange
        val a = "Good"
        val b = "Morning"

        // Act
        val result = monoid.combine(a, b)

        // Assert
        assertEquals("GoodMorning", result)
    }

    @Test
    fun `combining with empty string test`() {
        // Arrange
        val a = "Test"

        // Act & Assert
        assertEquals(a, monoid.combine(a, ""))
        assertEquals(a, monoid.combine("", a))
    }

    @Test
    fun `combine multiple empty strings test`() {
        // Arrange
        val empty1 = ""
        val empty2 = ""
        val empty3 = ""

        // Act
        val result = monoid.combine(monoid.combine(empty1, empty2), empty3)

        // Assert
        assertEquals("", result)
    }
}
