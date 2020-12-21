class Validator() {
    private var rules: ArrayList<Rule> = ArrayList()
    fun add(rule: Rule) {
        rules.add(rule)
    }
    fun verifyPassword(password: String) {
        verifyRules()
        for (rule in rules) {
            rule.verify(password)
        }
    }
    private fun verifyRules() {
        if (rules.size == 0) {
            throw ValidatorException("В валидаторе нет правил")
        }
        for (rule in rules) {
            var countEqualRules = 0
            for (rule2 in rules) {
                if (rule2.name == rule.name) {
                    countEqualRules += 1
                }
            }
            if (countEqualRules >= 2) {
                throw ValidatorException("Правила повторяются!")
            }
        }
    }
}
class ValidatorException(message: String) : Exception() {
    init {
        throw Exception(message)
    }
}
