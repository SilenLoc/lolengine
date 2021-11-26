package view.ui.search

import javafx.beans.property.StringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.control.TextField
import javafx.scene.layout.BorderPane
import javafx.scene.layout.FlowPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import model.champion.Champion
import model.service.ChampionService
import view.ui.mainTabPane
import java.util.*

class SearchView : BorderPane() {
  private val searchBox = SearchBox()
  private val resultBox = SearchResultBox()

  private val championIds = ChampionService.champions.toSet()



  init {
    this.top = searchBox
    this.center = resultBox

    searchBox.searchProperty.addListener { o, old, new ->
      resultBox.refreshResults(championIds.filter { it.id.lowercase().contains(new.lowercase()) }.toSet())
    }

  }

}

class SearchResultBox : ScrollPane(){
  private val container = FlowPane()

  init {
    this.content = container
    container.prefWrapLength = 1000.0
  }

  fun refreshResults(results: Set<Champion> ){
    container.children.clear()
    val championLinks =  championLinkButtons.filter { results.contains(it.champion) }
    container.children.addAll(championLinks)
  }

  companion object{
    val championLinkButtons: Set<ChampionLinkButton> = ChampionService.champions.map { ChampionLinkButton(it) }.toSet()
  }

}

class ChampionLinkButton(val champion: Champion): Button(){

  init {
    this.text = champion.name
    this.id = champion.id
    this.onAction = EventHandler {
      mainTabPane.selectionModel.select(mainTabPane.tabs.find { it.id == champion.id })
    }
  }
}


class SearchBox : VBox() {

  private val searchField = TextField()
  private val titleLabel = Label("Search: ")

  init {
    children.addAll(titleLabel, searchField)
  }

  val searchProperty: StringProperty = searchField.textProperty()

}