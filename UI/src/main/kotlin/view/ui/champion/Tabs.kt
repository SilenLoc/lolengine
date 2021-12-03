package view.ui.champion

import javafx.scene.control.Tab
import model.champion.Champion

var selectedTabId: String = "loreTab"

class ChampionTab(model: Champion) : Tab() {
  private val championView = ChampionView(model)

  init {
    this.isClosable = false
    this.text = model.name
    this.id = model.id
    this.content = championView

    this.selectedProperty().addListener { o ->
      championView.selectInnerTabWithId(selectedTabId)
    }
  }
}

class InfoTab: Tab("Info"), IIdentifiable {
  override val idAsString: String = "infotab"
  init {
    this.isClosable = false
    id = idAsString

    this.selectedProperty().addListener { o-> selectedTabId = this.idAsString }
  }
}

class StatsTab: Tab("Stats"), IIdentifiable {
  override val idAsString: String = "statstab"
  init {
    this.isClosable = false
    id = idAsString

    this.selectedProperty().addListener { o-> selectedTabId = this.idAsString }
  }
}

class SpellTab(private val name: String): Tab(name), IIdentifiable {
  override val idAsString: String = "spelltab"
  init {
    this.isClosable = false
    id = idAsString

    this.selectedProperty().addListener { o-> selectedTabId = this.idAsString }
  }
}

class SpellsTab: Tab("Spells"), IIdentifiable {
  override val idAsString: String = "spellstab"
  init {
    this.isClosable = false
    id = idAsString

    this.selectedProperty().addListener { o-> selectedTabId = this.idAsString }
  }
}

class LoreTab: Tab("Lore"), IIdentifiable {
  override val idAsString: String = "loreTab"
  init {
    this.isClosable = false
    id = idAsString

    this.selectedProperty().addListener { o-> selectedTabId = this.idAsString }
  }
}

interface IIdentifiable {
  val idAsString: String
}
