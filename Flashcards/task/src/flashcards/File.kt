package flashcards

import com.example.flashcards.Bot
import com.squareup.moshi.KotlinJsonAdapterFactory
import java.io.File
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class File {

    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val type = Types.newParameterizedType(List::class.java, Card::class.java)
    val cardAdapter = moshi.adapter<List<Card>>(type)

    inner class ImportCards {
        fun import() {
            Bot.Talk.sayFileName()
            val pathFile = Bot.readData()
            if (!File(pathFile).exists()) {
                Bot.Talk.sayFileNotFound()
            } else {
                cardAdapter.fromJson(File(pathFile).readLines()[0])
                    ?.forEach { mutableMapCardsNameAndDefinition[it.term] = it.definition }
                Bot.Talk.sayCardsHaveBeenLoaded(mutableMapCardsNameAndDefinition.size)
            }
        }
    }

    inner class ExportCards {
        fun export() {
            Bot.Talk.sayFileName()
            val pathFile = Bot.readData()
            val listOfCards = mutableListOf<Card>()
            mutableMapCardsNameAndDefinition.forEach { listOfCards.add(Card(it.key, it.value)) }
            File(pathFile).writeText(cardAdapter.toJson(listOfCards))
            Bot.Talk.sayCardSaved(mutableMapCardsNameAndDefinition.size)
        }
    }
}