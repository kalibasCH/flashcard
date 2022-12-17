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
                MyFile().ImportCards().import()
                start()
            }
            EXPORT -> {
                MyFile().ExportCards().export()
                start()
            }
            LOG -> {
                Bot.Log.log()
                start()
            }
            EXIT -> {
                Bot.Talk.sayBye()
                exitProcess(0)
            }
        }
    }
}