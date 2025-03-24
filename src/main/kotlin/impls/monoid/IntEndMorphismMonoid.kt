package impls.monoid

import interfaces.Monoid

/**
 * Represents a monoid of endomorphisms on integers.
 *
 * An endomorphism is a function that maps elements from a set to itself. In this
 * case, the set is the integers, and the endomorphisms are functions that map
 * integers to integers.
 *
 * The monoid operation is function composition, and the identity element is the
 * identity function that maps an integer to itself.
 */
class IntEndMorphismMonoid : Monoid<(Int) -> Int> {
    override fun identity(): (Int) -> Int = { input -> input }

    override fun combine(
        a: (Int) -> Int,
        b: (Int) -> Int,
    ): (Int) -> Int = { input -> a(b(input)) }
}
