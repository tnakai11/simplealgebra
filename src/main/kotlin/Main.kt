import impls.semigroup.LeftZeroBand

// TIP To <b>run</b> the code, press <shortcut actionId="Run"/>
// or click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val leftZeroBand = LeftZeroBand<Long>()

    val x = leftZeroBand.combine(1, 2)
    println("x: $x")
}
