package impls.monoid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * A test class for [IntEndMorphismMonoid].
 */
class IntEndMorphismMonoidTest {
    private val monoid = IntEndMorphismMonoid()

    @Test
    fun `identity function test`() {
        // Arrange
        val input = 5

        // Act
        val result = monoid.identity()(input)

        // Assert
        assertEquals(input, result)
    }

    @Test
    fun `combine function test`() {
        // Arrange
        val f: (Int) -> Int = { x -> x + 2 }
        val g: (Int) -> Int = { x -> x * 3 }
        val input = 4

        // Act
        val combined = monoid.combine(f, g)
        val result = combined(input)

        // Assert
        assertEquals(f(g(input)), result)
    }

    @Test
    fun `combine with identity function test`() {
        // Arrange
        val f: (Int) -> Int = { x -> x + 2 }
        val input = 4

        // Act
        val combinedWithIdentity = monoid.combine(f, monoid.identity())
        val resultWithIdentity = combinedWithIdentity(input)

        // Assert
        assertEquals(f(input), resultWithIdentity)
    }

    @Test
    fun `associativity test`() {
        // Arrange
        val f: (Int) -> Int = { x -> x + 2 }
        val g: (Int) -> Int = { x -> x * 3 }
        val h: (Int) -> Int = { x -> x - 1 }

        // Act
        val combined1 = monoid.combine(f, monoid.combine(g, h))
        val combined2 = monoid.combine(monoid.combine(f, g), h)

        // Assert
        assertEquals(combined1(0), combined2(0))
    }
}
