package impls.semigroup

import interfaces.Semigroup

/**
 * Implementation of a Rectangular Band.
 * https://en.wikipedia.org/wiki/Band_(algebra)
 *
 * A Rectangular Band is a specific type of `Semigroup` that operates
 * on pairs of elements. The `combine` operation always selects the
 * first component from the first pair and the second component from
 * the second pair:
 *
 * For all pairs `(a1, a2)` and `(b1, b2)`:
 * `combine((a1, a2), (b1, b2)) == (a1, b2)`
 *
 * This operation satisfies the associative property:
 * `combine(combine((a1, a2), (b1, b2)), (c1, c2)) ==
 * combine((a1, a2), combine((b1, b2), (c1, c2)))`.
 *
 * @param T the type of the first element in the pair
 * @param U the type of the second element in the pair
 */
class RectangularBand<T, U>: Semigroup<Pair<T, U>> {
    override fun combine(a: Pair<T, U>, b: Pair<T, U>): Pair<T, U> {
        val first = LeftZeroBand<T>().combine(a.first, b.first)
        val second = RightZeroBand<U>().combine(a.second, b.second)
        return first to second
    }
}