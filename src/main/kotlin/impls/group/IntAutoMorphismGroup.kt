package impls.group

import impls.intautomorphism.IntIdentityMorphism
import interfaces.Group
import interfaces.IntAutoMorphism

/**
 * Represents a Group for automorphisms of integers under function composition.
 * https://en.wikipedia.org/wiki/Automorphism
 *
 * In this implementation:
 * - `combine` performs function composition of two automorphisms.
 * - `identity` returns the identity automorphism.
 * - `inverse` returns the inverse of the given automorphism.
 */
class IntAutoMorphismGroup : Group<IntAutoMorphism> {
    override fun inverse(x: IntAutoMorphism): IntAutoMorphism = x.inverse()

    override fun identity(): IntAutoMorphism = IntIdentityMorphism()

    override fun combine(
        a: IntAutoMorphism,
        b: IntAutoMorphism,
    ): IntAutoMorphism = Composition(a, b)

    /**
     * Represents the composition of two automorphisms.
     *
     * @property a The first automorphism.
     * @property b The second automorphism.
     */
    private class Composition(
        private val a: IntAutoMorphism,
        private val b: IntAutoMorphism,
    ) : IntAutoMorphism {
        override fun apply(x: Int): Int = a.apply(b.apply(x))

        override fun inverse(): IntAutoMorphism = InverseComposition(a, b)
    }

    /**
     * Represents the inverse of the composition of two automorphisms.
     *
     * @property a The first automorphism.
     * @property b The second automorphism.
     */
    private class InverseComposition(
        private val a: IntAutoMorphism,
        private val b: IntAutoMorphism,
    ) : IntAutoMorphism {
        override fun apply(x: Int): Int = b.inverse().apply(a.inverse().apply(x))

        /*
         * The inverse of ab is (b^-1)(a^-1).
         *
         * Proof:
         *   ab(b^-1)(a^-1) = a(b(b^-1))(a^-1) = ai(a^-1) = a(a^-1) = i
         *   (b^-1)(a^-1)ab = (b^-1)((a^-1)a)b = (b^-1)ib = (b^-1)b = i
         */
        override fun inverse(): IntAutoMorphism = Composition(a, b)
    }
}
