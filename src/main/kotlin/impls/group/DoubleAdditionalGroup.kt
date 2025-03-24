package impls.group

import interfaces.Group

/**
 * Represents an implementation of a mathematical group for doubles under
 * addition. The group operation is double addition, the identity element is
 * 0.0, and the inverse of a double is its negation.
 *
 * In this implementation:
 * - `combine` performs addition of two doubles.
 * - `identity` returns 0.0, the additive identity.
 * - `inverse` returns the negation of the given double.
 */
class DoubleAdditionalGroup : Group<Double> {
    override fun inverse(x: Double): Double = -x

    override fun identity(): Double = 0.0

    override fun combine(
        a: Double,
        b: Double,
    ): Double = a + b
}
