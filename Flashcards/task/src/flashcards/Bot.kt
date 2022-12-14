package com.example.flashcards

class Bot {

    fun sayInputTheAction() = println("Input the action (add, remove, import, export, ask, exit):")

    fun sayPrintInputNumberCards() = println("Input the number of cards:")

    fun sayInputCard() = println("The card:")

    fun sayInputCardDefinition() = println("The definition of the card:")

    fun sayPrintDefinitionOf(term: String) = println("Print the definition of \"$term\":")

    fun sayCorrect() = println("Correct!")

    fun sayWrong(rightAnswer: String) = println("Wrong. The right answer is \"$rightAnswer\".")

    fun sayWrongButDefinitionIsExist(rightAnswer: String, rightTermForDefinition: String) = println(
        "Wrong. The right answer is \"$rightAnswer\", but your definition is correct for \"$rightTermForDefinition\"."
    )

    fun sayTermAlreadyExists(term: String) =
        println("The card \"$term\" already exists.")

    fun sayDefinitionAlreadyExists(definition: String) =
        println("The definition \"$definition\" already exists. Try again:")

    fun sayPairAdded(term: String, definition: String) = println("The pair (\"$term\":\"$definition\") has been added.")

    fun sayWhichCard() = println("Which card?")

    fun sayCardRemoved() = println("The card has been removed.")

    fun sayCanNotRemove(term: String) = println("Can't remove \"$term\": there is no such card.")

    fun sayBye() = println("Bye bye!")

    companion object {
        fun readData(): String {
            return readln()
        }
    }
}