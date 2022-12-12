package com.example.flashcards

class Bot {
    fun sayPrintInputNumberCards() = println("Input the number of cards:")
    fun sayInputCardNumName(cardNum: Int) = println("Card #$cardNum:")
    fun sayInputCardDefinition(cardNum: Int) = println("The definition for card #$cardNum:")
    fun sayPrintDefinitionOf(cardName: String) = println("Print the definition of \"$cardName\":")
    fun sayCorrect() = println("Correct!")
    fun sayWrong(rightAnswer: String) = println("Wrong. The right answer is \"$rightAnswer\".")
}