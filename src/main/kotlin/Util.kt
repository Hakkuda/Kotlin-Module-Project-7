import java.util.Scanner

class Util {
    companion object {
        private val scanner = Scanner(System.`in`)
        fun scan(): String {
            return scanner.nextLine()
        }
        fun inputAndCheck(): String {
            var enter = scan()
            while (true) {
                if (enter == "") {
                    println("Ввод не должен быть пустым. Попробуйте снова:")
                    enter = scan()
                } else return enter
            }
        }
    }
}