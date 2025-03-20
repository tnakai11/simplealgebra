package impls.monoidhomomorphism

import impls.monoid.NonNegativeIntAdditionMonoid
import impls.monoid.StringAdditionMonoid
import interfaces.Monoid
import interfaces.MonoidHomomorphism

/**
 * Represents a specific monoid homomorphism that maps non-negative integers
 * to strings by repeating the character "a".
 *
 * This class implements the `MonoidHomomorphism` interface and provides
 * structure-preserving mappings (functions) between a source monoid
 * (`NonNegativeIntAdditionMonoid`) of non-negative integers (using addition)
 * and a target monoid (`StringAdditionMonoid`) of strings (using concatenation).
 *
 * The mapping is defined such that:
 * - The identity element (0 in the source monoid) maps to the identity element
 *   ("" in the target monoid).
 * - The function adheres to the structure-preserving property:
 *   `f(a + b) == f(a) + f(b)` where "+" represents the combine operation in their respective monoids.
 *
 * The main behavior of the class is defined by:
 * - The `f(a: Int): String` function that maps an integer `a` to
 *   the string `"a".repeat(a)`, requiring `a` to be non-negative.
 */
class ARepeatHomomorphism : MonoidHomomorphism<Int, String> {
    override val source: Monoid<Int>
        get() = NonNegativeIntAdditionMonoid()

    override val target: Monoid<String>
        get() = StringAdditionMonoid()

    override fun f(a: Int): String {
        require(a >= 0) { "Input must be a non-negative integer" }
        return "a".repeat(a)
    }
}
