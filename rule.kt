abstract class Rule() {

    abstract fun verify(password: String)
    open val name: String
        get() = "hello"
}
