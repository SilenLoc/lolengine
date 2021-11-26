package view.ui

import javafx.beans.value.ChangeListener
import javafx.scene.control.TabPane
import javafx.scene.layout.BorderPane
import model.service.ChampionService

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
