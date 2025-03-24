package impls.intautomorphism

import interfaces.IntAutoMorphism

/**
 * Represents an automorphism that maps integers to themselves.
 */
class IntIdentityMorphism : IntAutoMorphism {
    override fun apply(x: Int): Int = x

    override fun inverse(): IntAutoMorphism = this
}
