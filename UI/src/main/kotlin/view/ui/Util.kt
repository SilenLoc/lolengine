package view.ui

fun addChar(str: String, ch: Char, position: Int): String? {
    return str.substring(0, position) + ch + str.substring(position)
}