package impls.group

import matrix.DoubleMatrix2x2
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * A test class for [DoubleMatrix2x2MultiplyGroup].
 */
class DoubleMatrix2x2MultiplyGroupTest {
    private val group = DoubleMatrix2x2MultiplyGroup()

    @Test
    fun `identity element test`() {
        // Arrange
        val element = DoubleMatrix2x2(2.0, 3.0, 4.0, 5.0)

        // Act & Assert
        assertEquals(element, group.combine(element, group.identity()))
        assertEquals(element, group.combine(group.identity(), element))
    }

    @Test
    fun `associativity test`() {
        // Arrange
        val a = DoubleMatrix2x2(1.0, 2.0, 3.0, 4.0)
        val b = DoubleMatrix2x2(2.0, 0.0, 1.0, 2.0)
        val c = DoubleMatrix2x2(0.0, 1.0, 2.0, 3.0)

        // Act & Assert
        assertEquals(
            group.combine(group.combine(a, b), c),
            group.combine(a, group.combine(b, c)),
        )
    }

    @Test
    fun `inverse element test`() {
        // Arrange
        val a = DoubleMatrix2x2(4.0, 7.0, 2.0, 6.0)

        // Act & Assert
        assertArrayEquals(group.identity().elements(), group.combine(a, group.inverse(a)).elements(), 1e-6)
        assertArrayEquals(group.identity().elements(), group.combine(group.inverse(a), a).elements(), 1e-6)
    }

    @Test
    fun `basic multiplication test`() {
        // Arrange
        val a = DoubleMatrix2x2(1.0, 2.0, 3.0, 4.0)
        val b = DoubleMatrix2x2(2.0, 0.0, 1.0, 2.0)

        // Act
        val result = group.combine(a, b)

        // Assert
        assertEquals(DoubleMatrix2x2(4.0, 4.0, 10.0, 8.0), result)
    }

    @Test
    fun `inverse of identity matrix test`() {
        // Arrange
        val identity = group.identity()

        // Act
        val inverse = group.inverse(identity)

        // Assert
        assertArrayEquals(identity.elements(), inverse.elements(), 1e-6)
    }

    @Test
    fun `combining an element with its inverse results in identity`() {
        // Arrange
        val a = DoubleMatrix2x2(3.0, 1.0, 0.0, 3.0)

        // Act
        val result = group.combine(a, group.inverse(a))

        // Assert
        assertArrayEquals(group.identity().elements(), result.elements(), 1e-6)
    }
}
