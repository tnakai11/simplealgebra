package interfaces

/**
 * Represents a structure-preserving homomorphism between two groups.
 * https://en.wikipedia.org/wiki/Group_homomorphism
 *
 * A group homomorphism maps elements from a source group (`source`) to a
 * target group (`target`) while preserving the group structure. This means:
 * - The identity element in the source group is mapped to the identity element
 *   in the target group. Formally: `f(source.identity()) == target.identity()`.
 * - The combine operation in the source group is preserved in the target group.
 *   Formally: `f(combine(a, b)) == combine(f(a), f(b))` for any elements `a, b`
 *   in the source group.
 * - The inverse operation in the source group is preserved in the target group.
 *   Formally: `f(inverse(a)) == inverse(f(a))` for any element `a` in the source group.
 *
 * @param A the type of elements in the source group
 * @param B the type of elements in the target group
 */
interface GroupHomomorphism<A, B> {
    /**
     * Represents the source group in a group homomorphism.
     *
     * A source group is the starting group from which elements are mapped
     * to a target group through a structure-preserving homomorphism. It satisfies
     * the properties of a group, including associativity, the existence of an
     * identity element, and the existence of inverse elements.
     *
     * The homomorphism preserves the group structure by ensuring that the identity
     * element, the combine operation, and the inverse operation in the source group
     * are consistently mapped to the identity element, combine operation, and inverse
     * operation in the target group.
     *
     * @property A the type of the elements in the source group.
     */
    val source: Group<A>

    /**
     * Represents the target group in a group homomorphism.
     *
     * A target group is the destination group to which elements from a source
     * group are mapped via a structure-preserving homomorphism. The homomorphism
     * ensures that the group properties, such as the identity element, the combine
     * operation, and the inverse operation, are preserved in the mapping.
     *
     * @property B the type of the elements in the target group.
     */
    val target: Group<B>

    /**
     * Maps an element of type A in the source group to an element of type B in the target group.
     *
     * This function represents a structure-preserving homomorphism that ensures the mapping adheres
     * to the properties of group homomorphisms:
     * - The identity element of the source group is mapped to the identity element of the target group.
     * - The combine operation is preserved during mapping.
     * - The inverse operation is preserved during mapping.
     *
     * @param a the element of the source group to be mapped
     * @return the corresponding element of the target group
     */
    fun f(a: A): B
}
