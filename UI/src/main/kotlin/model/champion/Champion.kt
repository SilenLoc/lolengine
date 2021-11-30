package model.champion

import model.json.SpecificChampionJson
import model.service.ChampionService

data class Champion(
  val id: String = "",
  val name: String = "",
  val blurb: String = "",
  val infos: List<Pair<String, Int>>,
  val stats: List<Pair<String, Double>>,
  val lore: String = ""
){

}


 object IndexedChampions{
  private val champions = ChampionService.champions

   val championsByName = champions.associateBy { it.name }

   val championsById = champions.associateBy { it.id }

   val championsByBlurb = champions.associateBy { it.blurb }

}



