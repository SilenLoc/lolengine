package view.ui

import model.api.ClientModel


var championsString: String = ""

fun startUp() {
    val model = ClientModel()
    model.getNewestInfo()
    championsString = model.observableString.value
}
