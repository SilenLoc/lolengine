package view.ui

import javafx.scene.control.TabPane
import javafx.scene.layout.BorderPane
import model.service.ChampionService
import view.ui.champion.ChampionTab
import view.ui.search.SearchView

private val mainPane = BorderPane()

val mainTabPane = TabPane()

fun uiStartUp(): BorderPane {

  mainPane.top = SearchView()
  mainPane.bottom = mainTabPane
  ChampionService.champions.forEach { model ->
    mainTabPane.tabs.add(ChampionTab(model))
  }

  setListeners()

  return mainPane
}

private fun setListeners() {

}
