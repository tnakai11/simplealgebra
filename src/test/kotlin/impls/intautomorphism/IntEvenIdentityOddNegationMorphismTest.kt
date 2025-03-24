package impls.intautomorphism

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * A test class for [IntEvenIdentityOddNegationMorphism]
 */
class IntEvenIdentityOddNegationMorphismTest {
    private val morphism = IntEvenIdentityOddNegationMorphism()

    @Test
    fun testApplyEven() {
        // Arrange
        val input = 4
        val expectedOutput = 4

        // Act
        val result = morphism.apply(input)

        // Assert
        assertEquals(expectedOutput, result)
    }

    @Test
    fun testApplyOdd() {
        // Arrange
        val input = 3
        val expectedOutput = -3

        // Act
        val result = morphism.apply(input)

        // Assert
        assertEquals(expectedOutput, result)
    }

    @Test
    fun testInverseEven() {
        // Arrange
        val input = 4
        val expectedOutput = 4

        // Act
        val result = morphism.inverse().apply(input)

        // Assert
        assertEquals(expectedOutput, result)
    }

    @Test
    fun testInverseOdd() {
        // Arrange
        val input = -3
        val expectedOutput = 3

        // Act
        val result = morphism.inverse().apply(input)

        // Assert
        assertEquals(expectedOutput, result)
    }

    @Test
    fun testApplyAndInverseEven() {
        // Arrange
        val input = 4

        // Act
        val result = morphism.inverse().apply(morphism.apply(input))

        // Assert
        assertEquals(input, result)
    }

    @Test
    fun testApplyAndInverseOdd() {
        // Arrange
        val input = 3

        // Act
        val result = morphism.inverse().apply(morphism.apply(input))

        // Assert
        assertEquals(input, result)
    }
}
