package interfaces

/**
 * Represents a structure-preserving homomorphism between two monoids.
 * https://en.wikipedia.org/wiki/Homomorphism
 *
 * A monoid homomorphism maps elements from a source monoid (`source`) to a
 * target monoid (`target`) while preserving the monoid structure. This means:
 * - The identity element in the source monoid is mapped to the identity element
 *   in the target monoid. Formally: `f(source.identity()) == target.identity()`.
 * - The combine operation in the source monoid is preserved in the target monoid.
 *   Formally: `f(combine(a, b)) == combine(f(a), f(b))` for any elements `a, b`
 *   in the source monoid.
 *
 * @param A the type of elements in the source monoid
 * @param B the type of elements in the target monoid
 */
interface MonoidHomomorphism<A, B> {
    /**
     * Represents the source monoid in a monoid homomorphism.
     *
     * A source monoid is the starting monoid from which elements are mapped
     * to a target monoid through a structure-preserving homomorphism. It satisfies
     * the properties of a monoid, including associativity and the existence of an
     * identity element.
     *
     * The homomorphism preserves the monoid structure by ensuring that the identity
     * element and the combine operation in the source monoid are consistently
     * mapped to the identity element and combine operation in the target monoid.
     *
     * @property A the type of the elements in the source monoid.
     */
    val source: Monoid<A>

    /**
     * Represents the target monoid in a monoid homomorphism.
     *
     * A target monoid is the destination monoid to which elements from a source
     * monoid are mapped via a structure-preserving homomorphism. The homomorphism
     * ensures that the monoid properties, such as the identity element and the
     * combine operation, are preserved in the mapping.
     *
     * @property B the type of the elements in the target monoid.
     */
    val target: Monoid<B>

    /**
     * Maps an element of type A in the source monoid to an element of type B in the target monoid.
     *
     * This function represents a structure-preserving homomorphism that ensures the mapping adheres
     * to the properties of monoid homomorphisms:
     * - The identity element of the source monoid is mapped to the identity element of the target monoid.
     * - The combine operation is preserved during mapping.
     *
     * @param a the element of the source monoid to be mapped
     * @return the corresponding element of the target monoid
     */
    fun f(a: A): B
}
