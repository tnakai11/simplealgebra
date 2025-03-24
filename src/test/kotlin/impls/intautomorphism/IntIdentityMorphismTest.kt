package impls.intautomorphism

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * A test class for [IntIdentityMorphism].
 */
class IntIdentityMorphismTest {
    private val morphism = IntIdentityMorphism()

    @Test
    fun testApply() {
        // Arrange
        val input = 2
        val expectedOutput = 2

        // Act
        val result = morphism.apply(input)

        // Assert
        assertEquals(expectedOutput, result)
    }

    @Test
    fun testInverse() {
        // Arrange
        val inverse = morphism.inverse()
        val input = 2
        val expectedOutput = 2

        // Act
        val result = inverse.apply(input)

        // Assert
        assertEquals(expectedOutput, result)
    }

    @Test
    fun testApplyAndInverse() {
        // Arrange
        val inverse = morphism.inverse()
        val input = 2

        // Act
        val result = inverse.apply(morphism.apply(input))

        // Assert
        assertEquals(input, result)
    }

    @Test
    fun testInverseAndApply() {
        // Arrange
        val inverse = morphism.inverse()
        val input = 2

        // Act
        val result = morphism.apply(inverse.apply(input))

        // Assert
        assertEquals(input, result)
    }
}
