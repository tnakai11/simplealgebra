package matrix

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * A test class for [DoubleMatrix2x2].
 */
class DoubleMatrix2x2Test {
    @Test
    fun testAdd() {
        // Arrange
        val matrix1 = DoubleMatrix2x2(1.0, 2.0, 3.0, 4.0)
        val matrix2 = DoubleMatrix2x2(5.0, 6.0, 7.0, 8.0)

        // Act
        val result = matrix1.add(matrix2)

        // Assert
        val expected = DoubleMatrix2x2(6.0, 8.0, 10.0, 12.0)
        assertArrayEquals(expected.elements(), result.elements(), 1e-6)
    }

    @Test
    fun testSubtract() {
        // Arrange
        val matrix1 = DoubleMatrix2x2(1.0, 2.0, 3.0, 4.0)
        val matrix2 = DoubleMatrix2x2(5.0, 6.0, 7.0, 8.0)

        // Act
        val result = matrix1.subtract(matrix2)

        // Assert
        val expected = DoubleMatrix2x2(-4.0, -4.0, -4.0, -4.0)
        assertArrayEquals(expected.elements(), result.elements(), 1e-6)
    }

    @Test
    fun testMultiply() {
        // Arrange
        val matrix1 = DoubleMatrix2x2(1.0, 2.0, 3.0, 4.0)
        val matrix2 = DoubleMatrix2x2(5.0, 6.0, 7.0, 8.0)

        // Act
        val result = matrix1.multiply(matrix2)

        // Assert
        val expected = DoubleMatrix2x2(19.0, 22.0, 43.0, 50.0)
        assertArrayEquals(expected.elements(), result.elements(), 1e-6)
    }

    @Test
    fun testScalarMultiply() {
        // Arrange
        val matrix = DoubleMatrix2x2(1.0, 2.0, 3.0, 4.0)
        val scalar = 2.0

        // Act
        val result = matrix.scalarMultiply(scalar)

        // Assert
        val excepted = DoubleMatrix2x2(2.0, 4.0, 6.0, 8.0)
        assertArrayEquals(excepted.elements(), result.elements(), 1e-6)
    }

    @Test
    fun testDeterminant() {
        // Arrange
        val matrix = DoubleMatrix2x2(1.0, 2.0, 3.0, 4.0)

        // Act
        val result = matrix.determinant()

        // Assert
        val expected = -2.0
        assertEquals(expected, result, 1e-6)
    }

    @Test
    fun testLieBracket() {
        // Arrange
        val matrix1 = DoubleMatrix2x2(1.0, 2.0, 3.0, 4.0)
        val matrix2 = DoubleMatrix2x2(5.0, 6.0, 7.0, 8.0)

        // Act
        val result = matrix1.lieBracket(matrix2)

        // Assert
        val expected = DoubleMatrix2x2(-4.0, -12.0, 12.0, 4.0)
        assertArrayEquals(expected.elements(), result.elements(), 1e-6)
    }

    /**
     * Verifies the Jacobi identity for the Lie bracket of 2x2 matrices.
     * The Jacobi identity is given by:
     * [A, [B, C]] + [B, [C, A]] + [C, [A, B]] = 0
     * where [X, Y] denotes the Lie bracket of matrices X and Y.
     *
     * Proof:
     * [A,[B,C]] = [A,(BC-CB)] = A(BC-CB)-(BC-CB)A = ABC-ACB-BCA+CBA
     * [B,[C,A]] = [B,(CA-AC)] = B(CA-AC)-(CA-AC)B = BCA-BAC-CAB+ACB
     * [C,[A,B]] = [C,(AB-BA)] = C(AB-BA)-(AB-BA)C = CAB-CBA-ABC+BAC
     */
    @Test
    fun testJacobiIdentity() {
        // Arrange
        val a = DoubleMatrix2x2(1.0, 2.0, 3.0, 4.0)
        val b = DoubleMatrix2x2(5.0, 6.0, 7.0, 8.0)
        val c = DoubleMatrix2x2(9.0, 10.0, 11.0, 12.0)

        // Act
        val abc = a.lieBracket(b.lieBracket(c))
        val bca = b.lieBracket(c.lieBracket(a))
        val cab = c.lieBracket(a.lieBracket(b))
        val lhs = abc.add(bca).add(cab)

        // Assert
        val expected = DoubleMatrix2x2(0.0, 0.0, 0.0, 0.0)
        assertArrayEquals(expected.elements(), lhs.elements(), 1e-6)
    }

    @Test
    fun testInverse() {
        // Arrange
        val matrix = DoubleMatrix2x2(4.0, 7.0, 2.0, 6.0)

        // Act
        val result = matrix.inverse()

        // Assert
        val expected = DoubleMatrix2x2(0.6, -0.7, -0.2, 0.4)
        assertArrayEquals(expected.elements(), result.elements(), 1e-6)
    }

    @Test
    fun testInverseThrowsExceptionForSingularMatrix() {
        // Arrange
        val matrix = DoubleMatrix2x2(1.0, 2.0, 2.0, 4.0)

        // Act & Assert
        val exception =
            assertThrows<IllegalArgumentException> {
                matrix.inverse()
            }
        assertEquals("Matrix is singular and cannot be inverted", exception.message)
    }
}
