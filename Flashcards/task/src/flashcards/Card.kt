package flashcards

import com.example.flashcards.Bot
import com.example.flashcards.mutableMapCardsNameAndDefinition

class Card {

    fun createCards() {

            Bot().sayInputCard()
            val term = Bot.readData()
            if (mutableMapCardsNameAndDefinition.containsKey(term)) {
                Bot().sayTermAlreadyExists(term)
            }

            Bot().sayInputCardDefinition()
            val definition = Bot.readData()
            if (mutableMapCardsNameAndDefinition.containsValue(definition)) {
                Bot().sayDefinitionAlreadyExists(definition)
            }

            mutableMapCardsNameAndDefinition += Pair(term, definition)
            Bot().sayPairAdded(term, definition)
    }

    fun removeCard() {
        Bot().sayWhichCard()
        val cardToRemove = Bot.readData()
        if (mutableMapCardsNameAndDefinition.containsKey(cardToRemove)) {
            mutableMapCardsNameAndDefinition.remove(cardToRemove)
            Bot().sayCardRemoved()
        } else {
            Bot().sayCanNotRemove(cardToRemove)
        }
    }

    fun openCards() {

        for ((term, definition) in mutableMapCardsNameAndDefinition) {
            Bot().sayPrintDefinitionOf(term)
            val answer = Bot.readData()
            if (answer == definition) {
                Bot().sayCorrect()
            } else if (mutableMapCardsNameAndDefinition.containsValue(answer)) {
                var rightTermForDefinition = ""
                mutableMapCardsNameAndDefinition.forEach { if (it.value == answer) rightTermForDefinition = it.key }
                Bot().sayWrongButDefinitionIsExist(definition, rightTermForDefinition)
            } else {
                Bot().sayWrong(definition)
            }
        }
    }

}