package view.ui

import javafx.scene.control.TabPane
import javafx.scene.layout.BorderPane
import model.service.ChampionService

fun uiStartUp(): BorderPane {

    val mainPane = BorderPane()

    val tabPane: TabPane = TabPane()


        mainPane.top = tabPane
        ChampionService.champions.forEach { model ->
            tabPane.tabs.add(ChampionTab(model))
        }


    return mainPane

}