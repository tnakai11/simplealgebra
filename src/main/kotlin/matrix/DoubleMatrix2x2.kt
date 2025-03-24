package matrix

/**
 * Represents a 2x2 matrix with double elements.
 *
 * @property a11 the element at the first row and first column
 * @property a12 the element at the first row and second column
 * @property a21 the element at the second row and first column
 * @property a22 the element at the second row and second column
 */
data class DoubleMatrix2x2(
    val a11: Double,
    val a12: Double,
    val a21: Double,
    val a22: Double,
) {
    /**
     * Adds this matrix to another matrix.
     *
     * @param other the matrix to add to this matrix
     * @return the result of the addition
     */
    fun add(other: DoubleMatrix2x2): DoubleMatrix2x2 =
        DoubleMatrix2x2(
            a11 + other.a11,
            a12 + other.a12,
            a21 + other.a21,
            a22 + other.a22,
        )

    /**
     * Subtracts another matrix from this matrix.
     *
     * @param other the matrix to subtract from this matrix
     * @return the result of the subtraction
     */
    fun subtract(other: DoubleMatrix2x2): DoubleMatrix2x2 =
        DoubleMatrix2x2(
            a11 - other.a11,
            a12 - other.a12,
            a21 - other.a21,
            a22 - other.a22,
        )

    /**
     * Multiplies this matrix by another matrix.
     *
     * @param other the matrix to multiply with this matrix
     * @return the result of the multiplication
     */
    fun multiply(other: DoubleMatrix2x2): DoubleMatrix2x2 =
        DoubleMatrix2x2(
            a11 * other.a11 + a12 * other.a21,
            a11 * other.a12 + a12 * other.a22,
            a21 * other.a11 + a22 * other.a21,
            a21 * other.a12 + a22 * other.a22,
        )

    /**
     * Multiplies this matrix by a scalar.
     *
     * @param scalar the scalar to multiply this matrix by
     * @return the result of the scalar multiplication
     */
    fun scalarMultiply(scalar: Double): DoubleMatrix2x2 =
        DoubleMatrix2x2(
            a11 * scalar,
            a12 * scalar,
            a21 * scalar,
            a22 * scalar,
        )

    /**
     * Returns the determinant of this matrix.
     *
     * @return the determinant of this matrix
     */
    fun determinant(): Double = a11 * a22 - a12 * a21

    /**
     * Returns the inverse of this matrix.
     *
     * @return the inverse of this matrix
     * @throws IllegalArgumentException if the matrix is singular (determinant is zero)
     */
    fun inverse(): DoubleMatrix2x2 {
        val det = determinant()
        require(det != 0.0) { "Matrix is singular and cannot be inverted" }

        return DoubleMatrix2x2(
            a22 / det,
            -a12 / det,
            -a21 / det,
            a11 / det,
        )
    }

    /**
     * Computes the Lie bracket [A, B] = AB - BA of this matrix with another matrix.
     *
     * @param other the matrix to compute the Lie bracket with
     * @return the result of the Lie bracket
     */
    fun lieBracket(other: DoubleMatrix2x2): DoubleMatrix2x2 {
        val ab = this.multiply(other)
        val ba = other.multiply(this)
        return ab.subtract(ba)
    }

    /**
     * Returns the elements of this matrix as an array.
     *
     * @return the elements of this matrix as an array
     */
    fun elements(): DoubleArray = listOf(a11, a12, a21, a22).toDoubleArray()
}
