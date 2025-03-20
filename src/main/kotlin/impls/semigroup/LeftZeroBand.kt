package impls.semigroup

import interfaces.Semigroup

/**
 * Implementation of a Left Zero Band.
 * https://en.wikipedia.org/wiki/Band_(algebra)
 *
 * A Left Zero Band is a specific type of `Semigroup` where the `combine`
 * operation always returns the first (left) operand, regardless of the second (right) operand.
 *
 * For all elements `a` and `b`:
 * `combine(a, b) == a`
 *
 * This satisfies the associative property:
 * `combine(combine(a, b), c) == combine(a, combine(b, c))`,
 * since the result is always the leftmost element.
 *
 * @param T the type of the elements that this Semigroup operates on
 */
class LeftZeroBand<T> : Semigroup<T> {
    override fun combine(
        a: T,
        b: T,
    ): T = a

    override fun combine(vararg elements: T): T = elements.first()
}
