package interfaces

/**
 * Represents a Monoid, which extends a Semigroup by adding an identity element.
 * https://en.wikipedia.org/wiki/Monoid
 *
 * In addition to adhering to the Semigroup associative property, a Monoid
 * introduces an identity element such that for any element `a` of type `T`:
 * - `combine(a, identity()) == a`
 * - `combine(identity(), a) == a`
 *
 * This property ensures that the identity element acts as a neutral element
 * in the binary operation defined by the implementation.
 */
interface Monoid<T> : Semigroup<T> {
    /**
     * Returns the identity element of the Monoid. The identity element is a special
     * element that, when combined with any other element using the Monoid's
     * `combine` operation, returns the other element unchanged.
     *
     * For any element `a` of type `T`:
     * - `combine(a, identity()) == a`
     * - `combine(identity(), a) == a`
     *
     * @return the identity element of the Monoid
     */
    fun identity(): T
}
