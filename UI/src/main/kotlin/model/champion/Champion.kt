package model.champion

import model.service.ChampionService

data class Champion(
  val id: String = "",
  val name: String = "",
  val blurb: String = "",
  val infos: List<Pair<String, Int>>,
  val stats: List<Pair<String, Double>>
)


 object IndexedChampions{
  private val champions = ChampionService.champions

   val championsByName = champions.associateBy { it.name }

   val championsById = champions.associateBy { it.id }

   val championsByBlurb = champions.associateBy { it.blurb }

}



