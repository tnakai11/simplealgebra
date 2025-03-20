package impls.monoid

import interfaces.Monoid

/**
 * A specific implementation of the Monoid interface for non-negative integers,
 * using addition as the binary operation and zero as the identity element.
 *
 * This class adheres to the Monoid laws:
 * 1. Associativity: The addition operation is associative.
 *    combine(combine(a, b), c) == combine(a, combine(b, c))
 * 2. Identity element: Zero serves as the identity element, meaning:
 *    combine(a, identity()) == a
 *    combine(identity(), a) == a
 *
 * Additionally, this implementation enforces the constraint that all input values
 * to the `combine` method must be non-negative integers. Any attempt to combine
 * negative integers will result in an exception being thrown.
 */
class NonNegativeIntAdditionMonoid : Monoid<Int> {
    override fun identity(): Int = 0

    override fun combine(
        a: Int,
        b: Int,
    ): Int {
        require(a >= 0 && b >= 0) { "This monoid only accepts non-negative integers" }
        return a + b
    }
}
