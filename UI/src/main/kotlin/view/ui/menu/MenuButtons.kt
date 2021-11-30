package view.ui.menu

import javafx.event.EventHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import view.ui.championsString
import view.ui.newChampionRequest
import view.ui.refreshMainTab


object MenuButtons {

  private val requestNewModelBtn = javafx.scene.control.Button("refresh Champions")


  fun getButtons(): List<javafx.scene.control.Button> {
    requestNewModelBtn.onAction = EventHandler {
      println("requesting..")
      GlobalScope.launch(Dispatchers.IO) {
        championsString = newChampionRequest()
      }
      refreshMainTab()
    }

    return listOf(requestNewModelBtn)
  }

}