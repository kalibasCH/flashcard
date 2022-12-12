package com.example.flashcards

val mutableListCardsName = mutableListOf<String>()
val mutableListCardsDefinition = mutableListOf<String>()

fun main() {
    Bot().sayPrintInputNumberCards()
    val numberOfCards = readln().toInt()
    for (cardNum in 1..numberOfCards) {
        Bot().sayInputCardNumName(cardNum)
        mutableListCardsName += readln()
        Bot().sayInputCardDefinition(cardNum)
        mutableListCardsDefinition += readln()
    }
    for (cardNum in 0 until mutableListCardsName.size) {
        val card = mutableListCardsName[cardNum]
        val cardDefinition = mutableListCardsDefinition[cardNum]
        Bot().sayPrintDefinitionOf(card)
        val answer = readln()
        if (answer == cardDefinition) {
            Bot().sayCorrect()
        } else {
            Bot().sayWrong(mutableListCardsDefinition[cardNum])
        }
    }
}