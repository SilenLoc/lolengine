package view.ui

import javafx.scene.control.TabPane
import javafx.scene.layout.BorderPane
import model.service.ChampionService
import view.ui.champion.ChampionTab

private val mainPane = BorderPane()

private val tabPane = TabPane()

fun uiStartUp(): BorderPane {
        mainPane.top = tabPane
        ChampionService.champions.forEach { model ->
            tabPane.tabs.add(ChampionTab(model))
        }

    setListeners()

    return mainPane
}

private fun setListeners() {

}
