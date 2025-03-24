package impls.intautomorphism

import interfaces.IntAutoMorphism

/**
 * Represents an automorphism on integers that adds 3 to an integer.
 */
class IntAddThreeMorphism : IntAutoMorphism {
    /**
     * The original automorphism.
     */
    private val original = this

    override fun apply(x: Int): Int = x + 3

    override fun inverse(): IntAutoMorphism =
        object : IntAutoMorphism {
            override fun apply(x: Int): Int = x - 3

            override fun inverse(): IntAutoMorphism = original
        }
}
