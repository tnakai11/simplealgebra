package impls.monoid

import interfaces.Monoid

/**
 * A specific implementation of the Monoid interface for Strings, using concatenation as the
 * binary operation and an empty string as the identity element.
 *
 * This class adheres to the Monoid laws:
 * 1. Associativity: The concatenation operation is associative.
 *    combine(combine(a, b), c) == combine(a, combine(b, c))
 * 2. Identity element: The empty string serves as the identity element, meaning:
 *    combine(a, identity()) == a
 *    combine(identity(), a) == a
 */
class StringAdditionMonoid : Monoid<String> {
    override fun identity(): String = ""

    override fun combine(
        a: String,
        b: String,
    ): String = a + b
}
