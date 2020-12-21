fun main(args: Array<String>) {
    val password = "T1e2s3T-132"
    val validator = Validator()
    validator.add(Length(5))
    validator.add(SymbolOrNumber())
    validator.add(Register())
    validator.add(Dictionary("D:/pswd-dict.txt"))
    validator.add(Entropy())
    validator.verifyPassword(password)
}
