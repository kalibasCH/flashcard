package flashcards

import com.example.flashcards.Bot

class StartProgram {

    fun start() {
        Bot().sayPrintInputNumberCards()
        val numberOfCards = Bot.readData().toInt()
        Card().createCards(numberOfCards)
        Card().openCards()
    }
}