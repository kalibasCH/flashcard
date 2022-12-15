package flashcards

val mutableMapCardsNameAndDefinition = mutableMapOf<String, String>()
const val ADD = "add"
const val REMOVE = "remove"
const val EXIT = "exit"
const val IMPORT = "import"
const val EXPORT = "export"
const val ASK = "ask"

fun main() {
    StartProgram().start()
}

/*

Пример 3: программа несколько раз запрашивает определения

Input the action (add, remove, import, export, ask, exit):
> add
The card:
> a brother of one's parent
The definition of the card:
> uncle
The pair ("a brother of one's parent":"uncle") has been added.

Input the action (add, remove, import, export, ask, exit):
> add
The card:
> a part of the body where the foot and the leg meet
The definition of the card:
> ankle
The pair ("a part of the body where the foot and the leg meet":"ankle") has been added.

Input the action (add, remove, import, export, ask, exit):
> ask
How many times to ask?
> 6
Print the definition of "a brother of one's parent":
> ankle
Wrong. The right answer is "uncle", but your definition is correct for "a part of the body where the foot and the leg meet".
Print the definition of "a part of the body where the foot and the leg meet":
> ??
Wrong. The right answer is "ankle".
Print the definition of "a brother of one's parent":
> uncle
Correct!
Print the definition of "a part of the body where the foot and the leg meet":
> ankle
Correct!
Print the definition of "a brother of one's parent":
> ??
Wrong. The right answer is "uncle".
Print the definition of "a part of the body where the foot and the leg meet":
> uncle
Wrong. The right answer is "ankle", but your definition is correct for "a brother of one's parent".

Input the action (add, remove, import, export, ask, exit):
> exit
Bye bye!

*/