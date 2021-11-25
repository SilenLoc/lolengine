package model.service

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.json.ChampionsJson

object ChampionLoader {

  fun loadChampions(json: String): ChampionsJson {
    return Json.decodeFromString<ChampionsJson>(json)
  }



}