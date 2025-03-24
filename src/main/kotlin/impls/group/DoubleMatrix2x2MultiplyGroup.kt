package impls.group

import interfaces.Group
import matrix.DoubleMatrix2x2
import kotlin.jvm.Throws

/**
 * Represents a Group for 2x2 matrices with double elements under matrix multiplication.
 */
class DoubleMatrix2x2MultiplyGroup : Group<DoubleMatrix2x2> {
    @Throws(IllegalArgumentException::class)
    override fun inverse(x: DoubleMatrix2x2): DoubleMatrix2x2 = x.inverse()

    override fun identity(): DoubleMatrix2x2 = DoubleMatrix2x2(1.0, 0.0, 0.0, 1.0)

    override fun combine(
        a: DoubleMatrix2x2,
        b: DoubleMatrix2x2,
    ): DoubleMatrix2x2 = a.multiply(b)
}
