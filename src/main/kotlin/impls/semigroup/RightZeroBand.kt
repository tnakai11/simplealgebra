package impls.semigroup

import interfaces.Semigroup

/**
 * Implementation of a Right Zero Band.
 * https://en.wikipedia.org/wiki/Band_(algebra)
 *
 * A Right Zero Band is a specific type of `Semigroup` where the `combine`
 * operation always returns the second (right) operand, regardless of the first (left) operand.
 *
 * For all elements `a` and `b`:
 * `combine(a, b) == b`
 *
 * This satisfies the associative property:
 * `combine(combine(a, b), c) == combine(a, combine(b, c))`,
 * since the result is always the rightmost element.
 *
 * @param T the type of the elements that this Semigroup operates on
 */
class RightZeroBand<T> : Semigroup<T> {
    override fun combine(
        a: T,
        b: T,
    ): T = b

    override fun combine(vararg elements: T): T = elements.last()
}
