package impls.group

import interfaces.Group

/**
 * Represents an implementation of a mathematical group for integers under
 * addition. The group operation is integer addition, the identity element is
 * 0, and the inverse of an integer is its negation.
 *
 * In this implementation:
 * - `combine` performs addition of two integers.
 * - `identity` returns 0, the additive identity.
 * - `inverse` returns the negation of the given integer.
 */
class IntAdditionalGroup : Group<Int> {
    override fun inverse(x: Int): Int = -x

    override fun identity(): Int = 0

    override fun combine(
        a: Int,
        b: Int,
    ): Int = a + b
}
