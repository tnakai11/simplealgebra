package interfaces

/**
 * Represents a Group, which extends a Monoid by introducing the concept of inverses.
 * https://en.wikipedia.org/wiki/Group_(mathematics)
 *
 * In addition to the properties of a Monoid, a Group requires that for any
 * element `x` of type `T`, there exists an element `y` such that:
 * - `combine(x, y) == identity()`
 * - `combine(y, x) == identity()`
 *
 * This property ensures that each element in the Group has a corresponding
 * inverse under the defined binary operation.
 *
 * @param T the type of the elements in the Group
 */
interface Group<T> : Monoid<T> {
    /**
     * Returns the inverse of the given element `x` in the group. The inverse is an element
     * such that when combined with `x` using the group's binary operation, it yields the
     * identity element of the group.
     *
     * @param x the element for which the inverse is to be determined
     * @return the inverse of the given element
     */
    fun inverse(x: T): T
}
