package view.ui


import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import model.api.ClientModel


var championsString: String = ""

fun startUp() {
  val model = ClientModel()
  model.getNewestInfo()
  championsString = model.observableString.value
}

suspend fun newChampionRequest() = coroutineScope {
  val newJson: Deferred<String> = async {
    val model = ClientModel()
    model.getNewestInfo()
    model.observableString.value
  }
  newJson.await()
}
