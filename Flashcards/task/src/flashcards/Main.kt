package com.example.flashcards

import flashcards.StartProgram

val mutableMapCardsNameAndDefinition = mutableMapOf<String, String>()
const val ADD = "add"
const val REMOVE = "remove"
const val EXIT = "exit"

fun main() {
    StartProgram().start()
}

/*

Input the action (add, remove, import, export, ask, exit):
> import
File name:
> ghost_file.txt
File not found.

Input the action (add, remove, import, export, ask, exit):
> add
The card:
> Japan
The definition of the card:
> Tokyo
The pair ("Japan":"Tokyo") has been added.

Input the action (add, remove, import, export, ask, exit):
> add
The card:
> Russia
The definition of the card:
> UpdateMeFromFile
The pair ("Russia":"UpdateMeFromFile") has been added.

Input the action (add, remove, import, export, ask, exit):
> import
File name:
> capitals.txt
28 cards have been loaded.

Input the action (add, remove, import, export, ask, exit):
> ask
How many times to ask?
> 1
Print the definition of "Russia":
> Moscow
Correct!

Input the action (add, remove, import, export, ask, exit):
> export
File name:
> capitalsNew.txt
29 cards have been saved.

Input the action (add, remove, import, export, ask, exit):
> exit
Bye bye!
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