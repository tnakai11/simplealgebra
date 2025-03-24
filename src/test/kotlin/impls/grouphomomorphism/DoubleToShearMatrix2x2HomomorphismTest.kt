package impls.grouphomomorphism

import matrix.DoubleMatrix2x2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * A test class for [DoubleToShearMatrix2x2Homomorphism].
 */
class DoubleToShearMatrix2x2HomomorphismTest {
    private val homomorphism = DoubleToShearMatrix2x2Homomorphism()

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
        val a = 2.0
        val b = 3.0
        val sourceCombine = homomorphism.source.combine(a, b)

        // Act
        val fSourceCombine = homomorphism.f(sourceCombine) // f(source.combine(a, b))
        val targetCombine = homomorphism.target.combine(homomorphism.f(a), homomorphism.f(b)) // target.combine(f(a), f(b))

        // Assert
        assertEquals(fSourceCombine, targetCombine)
    }

    @Test
    fun `inputs map correctly to shear matrices`() {
        // Arrange
        val cases =
            listOf(
                0.0 to DoubleMatrix2x2(1.0, 0.0, 0.0, 1.0),
                1.0 to DoubleMatrix2x2(1.0, 1.0, 0.0, 1.0),
                -1.0 to DoubleMatrix2x2(1.0, -1.0, 0.0, 1.0),
                2.5 to DoubleMatrix2x2(1.0, 2.5, 0.0, 1.0),
            )

        // Act & Assert
        for ((input, expected) in cases) {
            assertEquals(expected, homomorphism.f(input), "Failed for input: $input")
        }
    }
}
