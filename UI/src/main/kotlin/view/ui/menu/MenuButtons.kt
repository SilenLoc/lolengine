package view.ui.menu

import javafx.event.EventHandler
import view.ui.newChampionRequest



object MenuButtons {

  private val requestNewModelBtn = javafx.scene.control.Button("refresh Champions")


  fun getButtons(): List<javafx.scene.control.Button> {

    requestNewModelBtn.onAction = EventHandler {
      println("requesting..")
        val answer = newChampionRequest()
    }

    return listOf(requestNewModelBtn)
  }

}