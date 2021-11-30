package model.service

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.json.ChampionsJson
import model.json.SpecificChampionJson

object ChampionLoader {

  fun loadChampions(json: String): ChampionsJson {
    return Json.decodeFromString<ChampionsJson>(json)
  }

  fun loadSpecChampions(championsJsonList: List<String>): List<SpecificChampionJson> {
    return championsJsonList.map { decodeSpecChampion(it) }
  }

  private fun decodeSpecChampion(string:String): SpecificChampionJson {
   return try {
      val json = Json { ignoreUnknownKeys = true; allowStructuredMapKeys = true; coerceInputValues = true }
      return json.decodeFromString<SpecificChampionJson>(string)
    } catch (e: Exception) {
      println("decode failed with $string")
     throw e
    }

  }

}