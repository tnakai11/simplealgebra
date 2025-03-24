package impls.grouphomomorphism

import impls.group.DoubleAdditionalGroup
import impls.group.DoubleMatrix2x2MultiplyGroup
import interfaces.Group
import interfaces.GroupHomomorphism
import matrix.DoubleMatrix2x2

/**
 * Represents a homomorphism from the group of doubles under addition to the group of 2x2 matrices with double elements
 * under matrix multiplication. The homomorphism maps a double to a 2x2 matrix with the double as the shear component.
 * FYI: https://en.wikipedia.org/wiki/Shear_mapping
 *
 * This homomorphism is defined as follows:
 * - The source group is the group of doubles under addition.
 * - The target group is the group of 2x2 matrices with double elements under matrix multiplication.
 * - The homomorphism maps a double `a` to the 2x2 matrix:
 *   ```
 *   [ 1  a ]
 *   [ 0  1 ]
 *   ```
 *   This matrix represents a shear transformation in 2D space where `a` is the shear factor.
 *
 * Properties preserved by this homomorphism:
 * - The identity element (0 in the source group) maps to the identity matrix in the target group.
 * - The addition operation in the source group is preserved as matrix multiplication in the target group.
 * - The inverse element in the source group (negative of a double) maps to the inverse shear matrix in the target group.
 */
class DoubleToShearMatrix2x2Homomorphism : GroupHomomorphism<Double, DoubleMatrix2x2> {
    override val source: Group<Double> = DoubleAdditionalGroup()

    override val target: Group<DoubleMatrix2x2> = DoubleMatrix2x2MultiplyGroup()

    override fun f(a: Double): DoubleMatrix2x2 = DoubleMatrix2x2(1.0, a, 0.0, 1.0)
}
