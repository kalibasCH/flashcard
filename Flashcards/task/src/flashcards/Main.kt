package flashcards

val mutableListOfMyCards = mutableListOf<Card>()
const val ADD = "add"
const val REMOVE = "remove"
const val EXIT = "exit"
const val IMPORT = "import"
const val EXPORT = "export"
const val ASK = "ask"
const val LOG = "log"
const val HARDEST_CARD = "hardest card"
const val RESET_STATS = "reset stats"

fun main() {
    StartProgram().start()
}