package model.api

import javafx.beans.property.ListProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.collections.FXCollections
import javafx.event.EventHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import model.json.ChampionsJson
import model.json.SpecificChampionJson
import model.service.ChampionService


fun getNewestInfo(): Pair<ChampionsJson, List<SpecificChampionJson>> {
  return Client.sendLolRequest()
  }


