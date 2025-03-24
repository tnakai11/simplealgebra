package impls.intautomorphism

import interfaces.IntAutoMorphism

/**
 * Represents an automorphism on integers that maps even integers to themselves and odd
 * integers to their negations.
 */
class IntEvenIdentityOddNegationMorphism : IntAutoMorphism {
    override fun apply(x: Int): Int = if (x % 2 == 0) x else -x

    override fun inverse(): IntAutoMorphism = this
}
