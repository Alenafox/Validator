val UPPER: Array<Char> = arrayOf(
    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
    'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
)
val LOWER: Array<Char> = arrayOf(
    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
    'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
)
var NUMBER: Array<Char> = arrayOf(
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
)
var SYMBOL: Array<Char> = arrayOf(
    '@', '_', '.', '!', '^', '$', '#', '*', '+','-'
)

class SymbolOrNumber() : Rule() {
    override val name: String
        get() = "SymbolOrNumber"
    override fun verify(password: String) {
        var flag = false
        for (symbol in password) {
            if (SYMBOL.contains(symbol)) {
                flag = true
                break
            }
        }
        if (!flag) {
            throw RuleException("Пароль должен содержать специальные символы!")
        }

        flag = false

        for (symbol in password) {
            if (NUMBER.contains(symbol)) {
                flag = true
                break
            }
        }
        if (!flag) {
            throw RuleException("Пароль должен содержать цифры!")
        }
    }
}
class Register() : Rule() {
    override val name: String
        get() = "Register"
    override fun verify(password: String) {
        var flag = false
        for (symbol in password) {
            if (UPPER.contains(symbol)) {
                flag = true
                break
            }
        }
        if (!flag) {
            throw RuleException("Пароль должен содержать символы верхнего регистра!")
        }

        flag = false

        for (symbol in password) {
            if (LOWER.contains(symbol)) {
                flag = true
                break
            }
        }
        if (!flag) {
            throw RuleException("Пароль должен содержать символы нижнего регистра!")
        }
    }
}
class RuleException(message: String) : Exception() {
    init {
        throw Exception(message)
    }
}
