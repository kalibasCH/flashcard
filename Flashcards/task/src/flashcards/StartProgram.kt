package flashcards

import com.example.flashcards.*
import kotlin.system.exitProcess

class StartProgram {

    fun start() {
        Bot.Talk.sayInputTheAction()
        when (Bot.readData()) {
            ADD -> {
                Bot.WorkWithCards.addedCard()
                start()
            }
            REMOVE -> {
                Bot.WorkWithCards.removedCard()
                start()
            }
            ASK -> {
                Bot.WorkWithCards.ask()
                start()
            }
            IMPORT -> {
                File().ImportCards().import()
                start()
            }
            EXPORT -> {
                File().ExportCards().export()
                start()
            }
            EXIT -> {
                Bot.Talk.sayBye()
                exitProcess(0)
            }
        }
    }
}