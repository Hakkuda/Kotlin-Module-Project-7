



fun main(args: Array<String>) {

    println("Добро пожаловать в приложение \"Заметки\"")
    var inp: Int?
    val menu = Menu()

    while(true) {
        var result: Screen = menu.work(menu)
        when (result) {
            is Menu -> break
            is Archive -> {
                while(true) {
                    var currentArchive = result
                    result = menu.work(result)
                    when(result) {
                        is Archive -> break
                        is Note -> {
                            result = menu.work(result)
                            result = currentArchive
                        }
                    }
                }
            }
        }
    }
}

