package flashcards

import com.example.flashcards.ADD
import com.example.flashcards.Bot
import com.example.flashcards.EXIT
import com.example.flashcards.REMOVE
import kotlin.system.exitProcess

class StartProgram {

    fun start() {
        Bot().sayInputTheAction()
        when (Bot.readData()) {
            ADD -> {
                Card().createCards()
                start()
            }
            REMOVE -> {
                Card().removeCard()
                start()
            }
            EXIT -> {
                Bot().sayBye()
                exitProcess(0)
            }
        }
        Bot().sayPrintInputNumberCards()
        Card().createCards()
        Card().openCards()
    }
}