package model.champion

import model.json.SpecificChampionJson
import model.service.ChampionService

data class Champion(
  val id: String = "",
  val name: String = "",
  val infos: List<Pair<String, Int>>,
  val stats: List<Pair<String, Double>>,
  val lore: String = "",
  val spells: List<ChampionSpell>
)

data class ChampionSpell(
  val name: String="",
  val description: String="",
  val cooldown: String ="x",
  val cooldownBurn: String = "",
  val cost: String = "",
  val costType: String  = ""
)


 object IndexedChampions{
  private val champions = ChampionService.champions

   val championsByName = champions.associateBy { it.name }

   val championsById = champions.associateBy { it.id }


}



