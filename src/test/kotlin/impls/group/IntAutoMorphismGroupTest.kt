package impls.group

import impls.intautomorphism.IntAddThreeMorphism
import impls.intautomorphism.IntEvenIdentityOddNegationMorphism
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * A test class for [IntAutoMorphismGroup].
 */
class IntAutoMorphismGroupTest {
    private val group = IntAutoMorphismGroup()

    @Test
    fun `identity element test`() {
        // Arrange
        val a = IntEvenIdentityOddNegationMorphism()

        // Act & Assert
        assertEquals(a.apply(5), group.combine(a, group.identity()).apply(5))
        assertEquals(a.apply(5), group.combine(group.identity(), a).apply(5))
    }

    @Test
    fun `associativity test`() {
        // Arrange
        val a = IntEvenIdentityOddNegationMorphism()
        val b = IntAddThreeMorphism()
        val c = IntEvenIdentityOddNegationMorphism()

        // Act & Assert
        assertEquals(
            group.combine(group.combine(a, b), c).apply(5),
            group.combine(a, group.combine(b, c)).apply(5),
        )
    }

    @Test
    fun `inverse element test`() {
        // Arrange
        val a = IntAddThreeMorphism()

        // Act & Assert
        assertEquals(group.identity().apply(5), group.combine(a, group.inverse(a)).apply(5))
        assertEquals(group.identity().apply(5), group.combine(group.inverse(a), a).apply(5))
    }

    @Test
    fun `basic composition test`() {
        // Arrange
        val a = IntEvenIdentityOddNegationMorphism()
        val b = IntAddThreeMorphism()
        val input = 5

        // Act & Assert
        assertEquals(a.apply(b.apply(input)), group.combine(a, b).apply(input))
    }

    @Test
    fun `inverse of composition test`() {
        // Arrange
        val a = IntEvenIdentityOddNegationMorphism()
        val b = IntAddThreeMorphism()
        val input = 5
        val composition = group.combine(a, b)
        val inverse = group.inverse(composition)

        // Act & Assert
        assertEquals(group.identity().apply(input), inverse.apply(composition.apply(input)))
        assertEquals(group.identity().apply(input), composition.apply(inverse.apply(input)))
    }
}
