class Menu(
    override val name: String = "Меню",
    override val list: MutableList<Screen> = mutableListOf()
) : Screen() {}