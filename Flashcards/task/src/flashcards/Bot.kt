package com.example.flashcards

import flashcards.mutableMapCardsNameAndDefinition
import java.util.Random

class Bot {

    companion object {
        fun readData(): String {
            return readln()
        }
    }

    object Talk {
        fun sayHowManyTimeToAsk() = println("How many times to ask?")

        fun sayPrintTheDefinitionOf(term: String) = println("Print the definition of \"$term\":")

        fun sayCorrect() = println("Correct!")

        fun sayWrongButDefinitionIsExist(rightAnswer: String, rightTermForDefinition: String) =
            println(
                "Wrong. The right answer is \"$rightAnswer\", but your definition is correct for \"$rightTermForDefinition\"."
            )

        fun sayWrong(rightAnswer: String) = println("Wrong. The right answer is \"$rightAnswer\".")

        fun sayInputTheAction() =
            println("Input the action (add, remove, import, export, ask, exit):")

        fun sayInputCard() = println("The card:")

        fun sayInputCardDefinition() = println("The definition of the card:")

        fun sayTermAlreadyExists(term: String) =
            println("The card \"$term\" already exists.")

        fun sayDefinitionAlreadyExists(definition: String) =
            println("The definition \"$definition\" already exists. Try again:")

        fun sayPairAdded(term: String, definition: String) =
            println("The pair (\"$term\":\"$definition\") has been added.")

        fun sayWhichCard() = println("Which card?")

        fun sayCardRemoved() = println("The card has been removed.")

        fun sayCanNotRemove(term: String) =
            println("Can't remove \"$term\": there is no such card.")

        fun sayBye() = println("Bye bye!")

        fun sayFileNotFound() = println("File not found.")

        fun sayCardsHaveBeenLoaded(numberOfLoadedCards: Int) =
            println("$numberOfLoadedCards cards have been loaded.")

        fun sayFileName() = println("File name:")

        fun sayCardSaved(numberOfCards: Int) = println("$numberOfCards cards have been saved.")

    }

    object WorkWithCards {

        fun addedCard() {
            Talk.sayInputCard()
            val term = readData()
            if (mutableMapCardsNameAndDefinition.containsKey(term)) {
                Talk.sayTermAlreadyExists(term)
            }
            Talk.sayInputCardDefinition()
            val definition = readData()
            if (mutableMapCardsNameAndDefinition.containsValue(definition)) {
                Talk.sayDefinitionAlreadyExists(definition)
            }
            mutableMapCardsNameAndDefinition += Pair(term, definition)
            Talk.sayPairAdded(term, definition)
        }

        fun removedCard() {
            Talk.sayWhichCard()
            val cardToRemove = readData()
            if (mutableMapCardsNameAndDefinition.containsKey(cardToRemove)) {
                mutableMapCardsNameAndDefinition.remove(cardToRemove)
                Talk.sayCardRemoved()
            } else {
                Talk.sayCanNotRemove(cardToRemove)
            }
        }

        fun ask() {
            Talk.sayHowManyTimeToAsk()
            val numberOfQuestions = readData().toInt()
            repeat(numberOfQuestions) {
                val listMyCards = mutableMapCardsNameAndDefinition.toList().toMutableList()
                val randomCard = listMyCards[Random().nextInt(mutableMapCardsNameAndDefinition.size - 1)]
                Talk.sayPrintTheDefinitionOf(randomCard.first)
                val answer = readData()
                if (answer == randomCard.second) {
                    Talk.sayCorrect()
                } else if (mutableMapCardsNameAndDefinition.containsValue(answer)) {
                    var rightTermForDefinition = ""
                    mutableMapCardsNameAndDefinition.forEach { if (it.value == answer) rightTermForDefinition = it.key }
                    Talk.sayWrongButDefinitionIsExist(randomCard.second, rightTermForDefinition)
                } else {
                    Talk.sayWrong(randomCard.second)
                }
            }
        }
    }

}