package com.example.flashcards

class Bot {
    fun sayPrintInputNumberCards() = println("Input the number of cards:")
    fun sayInputCardNumName(cardNum: Int) = println("Card #$cardNum:")
    fun sayInputCardDefinition(cardNum: Int) = println("The definition for card #$cardNum:")
    fun sayPrintDefinitionOf(term: String) = println("Print the definition of \"$term\":")
    fun sayCorrect() = println("Correct!")
    fun sayWrong(rightAnswer: String) = println("Wrong. The right answer is \"$rightAnswer\".")
    fun sayWrongButDefinitionIsExist(rightAnswer: String, rightTermForDefinition: String) = println(
        "Wrong. The right answer is \"$rightAnswer\", but your definition is correct for \"$rightTermForDefinition\"."
    )

    fun sayTermAlreadyExists(term: String) =
        println("The term \"$term\" already exists. Try again:")

    fun sayDefinitionAlreadyExists(definition: String) =
        println("The definition \"$definition\" already exists. Try again:")

    companion object {
        fun readData(): String {
            return readln()
        }
    }
}