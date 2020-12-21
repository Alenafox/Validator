import java.io.File

class Dictionary(fileName: String) : Rule() {
    override val name: String
        get() = "Dictionary"

    private val dictionaryName: String = fileName
    val file = File(dictionaryName)
    val text = file.readText().split("\n")

    override fun verify(password: String) {
        for (word in text) {
            if ((password.contains(word)) && (word != "")){
                throw RuleException("Пароль содержит запрещенное слово!")
            }
        }
    }
}
