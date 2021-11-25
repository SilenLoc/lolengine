package lolmodel

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object ChampionLoader {

  fun loadChampions(json: String): Champions {
    return Json.decodeFromString<Champions>(json)
  }



}