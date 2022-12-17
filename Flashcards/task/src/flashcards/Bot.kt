package com.example.flashcards

import flashcards.mutableMapCardsNameAndDefinition
import java.util.Random
import java.io.File
import java.nio.file.Files
import kotlin.io.path.Path

class Bot {

    companion object {
        fun readData(): String {
            val inputData = readln()
            Log.logMyHistory(inputData)
            return inputData
        }
    }

    object Talk {
        fun sayHowManyTimeToAsk() {
            val outputData = "How many times to ask?"
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayPrintTheDefinitionOf(term: String) {
            val outputData = "Print the definition of \"$term\":"
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayCorrect() {
            val outputData = "Correct!"
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayWrongButDefinitionIsExist(rightAnswer: String, rightTermForDefinition: String) {
            val outputData = "Wrong. The right answer is \"$rightAnswer\", but your definition is correct for \"$rightTermForDefinition\"."
            Log.logMyHistory(outputData)
            println(outputData)
        }

        fun sayWrong(rightAnswer: String) {
            val outputData = "Wrong. The right answer is \"$rightAnswer\"."
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayInputTheAction() {
            val outputData = "Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):"
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayInputCard() {
            val outputData = "The card:"
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayInputCardDefinition() {
            val outputData = "The definition of the card:"
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayTermAlreadyExists(term: String) {
            val outputData = "The card \"$term\" already exists."
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayDefinitionAlreadyExists(definition: String) {
            val outputData = "The definition \"$definition\" already exists. Try again:"
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayPairAdded(term: String, definition: String) {
            val outputData = "The pair (\"$term\":\"$definition\") has been added."
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayWhichCard() {
            val outputData = "Which card?"
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayCardRemoved() {
            val outputData = "The card has been removed."
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayCanNotRemove(term: String) {
            val outputData = "Can't remove \"$term\": there is no such card."
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayBye() {
            val outputData = "Bye bye!"
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayFileNotFound() {
            val outputData = "File not found."
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayCardsHaveBeenLoaded(numberOfLoadedCards: Int) {
            val outputData = "$numberOfLoadedCards cards have been loaded."
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayFileName() {
            val outputData = "File name:"
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayCardSaved(numberOfCards: Int) {
            val outputData = "$numberOfCards cards have been saved."
            Log.logMyHistory(outputData)
            println(outputData)
        }
        fun sayLogHasBeenSaved() = println("The log has been saved.")
    }

    object WorkWithCards {

        fun addedCard() {
            Talk.sayInputCard()
            val term = readData()
            if (mutableMapCardsNameAndDefinition.containsKey(term)) {
                Talk.sayTermAlreadyExists(term)
                return
            }
            Talk.sayInputCardDefinition()
            val definition = readData()
            if (mutableMapCardsNameAndDefinition.containsValue(definition)) {
                Talk.sayDefinitionAlreadyExists(definition)
                return
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
            val listMyCards = mutableMapCardsNameAndDefinition.toList().toMutableList()
            repeat(numberOfQuestions) {
                val randomCard =
                    listMyCards[Random().nextInt(listMyCards.size)]
                Talk.sayPrintTheDefinitionOf(randomCard.first)
                val answer = readData()
                if (answer == randomCard.second) {
                    Talk.sayCorrect()
                } else if (mutableMapCardsNameAndDefinition.containsValue(answer)) {
                    var rightTermForDefinition = ""
                    mutableMapCardsNameAndDefinition.forEach {
                        if (it.value == answer) rightTermForDefinition = it.key
                    }
                    Talk.sayWrongButDefinitionIsExist(randomCard.second, rightTermForDefinition)
                } else {
                    Talk.sayWrong(randomCard.second)
                }
                listMyCards.remove(randomCard)
            }
        }
    }

    object Log {

        fun logMyHistory(data: String) {
            val pathFileForLog = "MyLog.txt"
            if (File(pathFileForLog).exists()) {
                File(pathFileForLog).appendText("${data}\n")
            } else {
                File(pathFileForLog).writeText("${data}\n")
            }
        }


        fun log() {
            Talk.sayFileName()
            val pathFileForLog = readData()
            Files.move(Path("MyLog.txt"), Path(pathFileForLog))
            Talk.sayLogHasBeenSaved()
        }
    }

}