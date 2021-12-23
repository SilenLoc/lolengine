package view.ui.menu

import javafx.event.EventHandler
import model.service.ChampionService
import model.service.championexport.ChampionExportService
import view.ui.FileChooserWindow
import view.ui.newChampionRequest



object MenuButtons {

  private val requestNewModelBtn = javafx.scene.control.Button("refresh Champions")

  private val exportChampionsBtn = javafx.scene.control.Button("export Champions")


  fun getButtons(): List<javafx.scene.control.Button> {

    requestNewModelBtn.onAction = EventHandler {
      println("requesting..")
      val answer = newChampionRequest()
    }

    exportChampionsBtn.onAction = EventHandler {
      val file = FileChooserWindow.save()

      if (file != null) {
        ChampionExportService.exportChampions(file, ChampionService.champions)
      }
    }


    return listOf(requestNewModelBtn, exportChampionsBtn)
  }

}