package flashcards

data class Card(val term: String, val definition: String, var numberOfErrorInCard: Int = 0)
