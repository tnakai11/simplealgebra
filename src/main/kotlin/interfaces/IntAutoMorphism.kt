package interfaces

/**
 * Represents an automorphism on integers.
 *
 * An automorphism is a function that maps elements from a set to itself. In this
 * case, the set is the integers, and the automorphisms are functions that map
 * integers to integers.
 */
interface IntAutoMorphism {
    /**
     * Applies the automorphism to the given integer.
     *
     * @param x the integer to apply the automorphism to
     * @return the result of applying the automorphism to the integer
     */
    fun apply(x: Int): Int

    /**
     * Returns the inverse of this automorphism.
     *
     * @return the inverse of this automorphism
     */
    fun inverse(): IntAutoMorphism
}
