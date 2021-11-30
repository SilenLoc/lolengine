package view.ui

import javafx.scene.control.TabPane
import javafx.scene.layout.BorderPane
import model.service.ChampionService
import view.ui.champion.ChampionTab
import view.ui.menu.Menu
import view.ui.menu.MenuButtons
import view.ui.search.SearchView

private val mainPane = BorderPane()

val mainTabPane = TabPane()

fun uiStartUp(): BorderPane {

  mainPane.top = Menu(MenuButtons.getButtons())
  mainPane.center = SearchView()
  mainPane.bottom = mainTabPane

  ChampionService.champions.forEach { model ->
    mainTabPane.tabs.add(ChampionTab(model))
  }

  setListeners()

  return mainPane
}

fun refreshMainTab() {
  mainTabPane.tabs.clear()
  ChampionService.champions.forEach { model ->
    mainTabPane.tabs.add(ChampionTab(model))
  }
}

private fun setListeners() {

}
