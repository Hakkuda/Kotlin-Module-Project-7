open class Screen() {
    open val list = mutableListOf<Screen>()
    open val name: String = "Экран"

    override fun toString(): String {
        return name
    }

    fun toString2(): String {
        var string = ""
        when (this) {
            is Menu -> string += "Главное меню\n0. Создать архив\n"
            is Archive -> string += "Архив $name\n0. Создать заметку\n"
            is Note -> {
                string += "Заметка $name\n${text}\n0. Добавить текст\n1. Выход\n"
                return string
            }
        }
        for (i in 1..list.size) {
            string += "$i. ${list[i - 1]}\n"
        }
        string += "${list.size + 1}. Выход\n"
        return string
    }

    fun create() {

        when(this) {
            is Menu -> println("Введите название архива:")
            is Archive -> println("Введите название заметки:")
        }
        val enterName = Util.inputAndCheck()

        when(this) {
            is Menu -> {
                list.add(Archive(enterName))
                println("Архив создан!\n")
            }
            is Archive -> {
                println("Введите текст заметки:")
                val enterText = Util.inputAndCheck()
                list.add(Note(enterName, enterText))
                println("Заметка создана!\n")
            }

        }
    }

    fun work(screen: Screen): Screen {
        var inp: Int?
        while(true) {
            println(screen.toString2())
            inp = Util.inputAndCheck().toIntOrNull()
            when (inp) {
                null -> println("Пожалуйста, введите число:")
                0 -> {
                    if (screen is Note) {
                        println("Введите текст")
                        screen.text += "\n" + Util.inputAndCheck()
                        println("Текст успешно добавлен\n")
                    } else screen.create()
                }
                screen.list.size + 1 -> {
                    //println("Выход")
                    return screen
                }
                in 1..screen.list.size -> {

                    return screen.list[inp - 1]
                    /*
                    while(true) {
                        println(archive.toString2())
                        inp = Util.inputAndCheck().toIntOrNull()
                        when(inp) {
                            null -> println("Пожалуйста, введите число:")
                            0 -> archive.create()
                            in 1..archive.list.size -> {

                                val note = archive.list[inp - 1]

                                while(true) {
                                    println(note.toString2())
                                    inp = Util.inputAndCheck().toIntOrNull()
                                    when(inp) {
                                        null -> println("Пожалуйста, введите число:")
                                        0 -> {
                                            println("Введите текст")
                                            if (note is Note) {
                                                note.text += "\n" + Util.inputAndCheck()
                                            }
                                            println("Текст успешно добавлен")
                                        }
                                        1 -> {
                                            println("Выход")
                                            break
                                        }
                                        else -> println("Такого числа нет. Пожалуйста, попробуйте ввести снова:")
                                    }
                                }

                            }
                            archive.list.size + 1 -> {
                                println("Выход")
                                break
                            }
                            else -> println("Такого числа нет. Пожалуйста, попробуйте ввести снова:")
                        }

                    }
                    */
                }
                else -> println("Такого числа нет. Пожалуйста, попробуйте ввести снова:")
            }
        }
    }

}

