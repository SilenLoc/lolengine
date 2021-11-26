package view.ui

import javafx.scene.control.Label
import javafx.scene.control.TabPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import model.champion.Champion


class ChampionView(model: Champion) : BorderPane() {

  private val championInnerTabPane = TabPane()
  private val loreTab = InfoTab()
  private val infoTab = LoreTab()
  private val statsTab = StatsTab()


  init {
    loreTab.content = MainLoreView(model.blurb, "no full lore yet")
    infoTab.content = ChampionInfoView(model.infos)
    statsTab.content = ChampionStatsView(model.stats)

    championInnerTabPane.tabs.addAll(loreTab, infoTab, statsTab)

    this.bottom = championInnerTabPane
  }

  fun selectInnerTabWithId(id: String) {
    championInnerTabPane.selectionModel.select(championInnerTabPane.tabs.find { it.id == id })
  }

}

class ChampionStatsView(stats: List<Pair<String, Double>>) : VBox(){

  init {
    val infoViews = stats.map { (title, double) ->
      Label("$title: $double")
    }

    this.children.addAll(infoViews)
  }
}

class MainLoreView(meta: String, fullLore: String) : BorderPane() {

  init {
    this.bottom = BlurbView(meta)
    this.center = FullLoreView(fullLore)
  }
}

class ChampionInfoView(infos: List<Pair<String, Int>>) : VBox() {

  init {
    val infoViews = infos.map { (title, int) ->
      Label("$title: $int")
    }
    this.children.addAll(infoViews)
  }
}




