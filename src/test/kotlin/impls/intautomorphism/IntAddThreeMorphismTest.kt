package impls.intautomorphism

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * A test class for [IntAddThreeMorphism].
 */
class IntAddThreeMorphismTest {
    private val morphism = IntAddThreeMorphism()

    @Test
    fun testApply() {
        // Arrange
        val input = 2
        val expectedOutput = 5

        // Act
        val result = morphism.apply(input)

        // Assert
        assertEquals(expectedOutput, result)
    }

    @Test
    fun testInverse() {
        // Arrange
        val inverse = morphism.inverse()
        val input = 5
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
        val input = 5

        // Act
        val result = morphism.apply(inverse.apply(input))

        // Assert
        assertEquals(input, result)
    }
}
