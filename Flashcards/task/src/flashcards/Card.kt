package flashcards

import com.example.flashcards.Bot
import com.example.flashcards.mutableMapCardsNameAndDefinition

class Card {

    fun createCards(numberOfCards: Int) {

        for (cardNum in 1..numberOfCards) {
            Bot().sayInputCardNumName(cardNum)
            var term = Bot.readData()
            while (mutableMapCardsNameAndDefinition.containsKey(term)) {
                Bot().sayTermAlreadyExists(term)
                term = Bot.readData()
            }

            Bot().sayInputCardDefinition(cardNum)
            var definition = Bot.readData()
            while (mutableMapCardsNameAndDefinition.containsValue(definition)) {
                Bot().sayDefinitionAlreadyExists(definition)
                definition = Bot.readData()
            }

            mutableMapCardsNameAndDefinition += Pair(term, definition)
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