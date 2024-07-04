class Archive(
    override val name: String
): Screen() {
    override val list: MutableList<Screen> = mutableListOf()
}