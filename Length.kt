class Length(_length: Int) : Rule() {
    private val length: Int = _length

    override fun verify(password: String) {
        if (password.length < length) {
            throw RuleException("Пароль должен быть не менее $length символов")
        }
    }
}
