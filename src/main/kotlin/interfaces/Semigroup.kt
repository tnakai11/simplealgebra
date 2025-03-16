package interfaces

/**
 * Represents a Semigroup, which defines an associative binary operation
 * for a given type `T`.
 *
 * A Semigroup must adhere to the associative property, meaning
 * `combine(combine(a, b), c) == combine(a, combine(b, c))` for any
 * values `a`, `b`, and `c`.
 */
interface Semigroup<T> {
    /**
     * Combines two elements of type T into a single element using the
     * associative binary operation defined by the implementation.
     *
     * @param a the first element to combine
     * @param b the second element to combine
     * @return the result of combining the two elements
     */
    fun combine(a: T, b: T): T
}