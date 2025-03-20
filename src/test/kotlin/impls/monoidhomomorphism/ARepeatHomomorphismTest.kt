package impls.monoidhomomorphism

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * A test class for [ARepeatHomomorphism].
 */
class ARepeatHomomorphismTest {
    private val homomorphism = ARepeatHomomorphism()

    @Test
    fun `identity element property test`() {
        // Arrange
        val sourceIdentity = homomorphism.source.identity()
        val targetIdentity = homomorphism.target.identity()

        // Act
        val result = homomorphism.f(sourceIdentity)

        // Assert
        assertEquals(targetIdentity, result)
    }

    @Test
    fun `homomorphism preserves binary operation test`() {
        // Arrange
        val a = 2
        val b = 3
        val sourceCombine = homomorphism.source.combine(a, b)

        // Act
        val fSourceCombine = homomorphism.f(sourceCombine) // f(source.combine(a, b))
        val targetCombine = homomorphism.target.combine(homomorphism.f(a), homomorphism.f(b)) // target.combine(f(a), f(b))

        // Assert
        assertEquals(fSourceCombine, targetCombine)
    }

    @Test
    fun `positive inputs map correctly to repeated strings`() {
        // Arrange
        val cases =
            listOf(
                0 to "",
                1 to "a",
                2 to "aa",
                5 to "aaaaa",
            )

        // Act & Assert
        for ((input, expected) in cases) {
            assertEquals(expected, homomorphism.f(input), "Failed for input: $input")
        }
    }

    @Test
    fun `negative input throws exception`() {
        assertThrows<IllegalArgumentException> {
            homomorphism.f(-1)
        }
    }
}
