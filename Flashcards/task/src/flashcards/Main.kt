package flashcards

val mutableMapCardsNameAndDefinition = mutableMapOf<String, String>()
const val ADD = "add"
const val REMOVE = "remove"
const val EXIT = "exit"
const val IMPORT = "import"
const val EXPORT = "export"
const val ASK = "ask"

fun main() {
    StartProgram().start()
}