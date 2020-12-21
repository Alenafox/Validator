import kotlin.math.log2

class Entropy() : Rule() {
    override val name: String
        get() = "Entropy"
    var N = 0
    override fun verify(password: String) {
        for (symbol in password) {
            if (SYMBOL.contains(symbol)) {
                N += NUMBER.size
                break
            }
        }
        for (symbol in password) {
            if (NUMBER.contains(symbol)) {
                N += NUMBER.size
                break
            }
        }
        for (symbol in password) {
            if (LOWER.contains(symbol)) {
                N += NUMBER.size
                break
            }
        }
        for (symbol in password) {
            if (UPPER.contains(symbol)) {
                N += NUMBER.size
                break
            }
        }
        var summ = 0.0
        for (i in 1..N) {
            summ += (1.toDouble() / N) * log2((1.toDouble() / N))
        }
        summ = -summ
        if (summ < 5) {
            throw RuleException("Величина ентропии низка")
        }
    }
}
