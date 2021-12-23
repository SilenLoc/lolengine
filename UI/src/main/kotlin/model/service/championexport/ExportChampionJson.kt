package model.service.championexport

import kotlinx.serialization.Serializable

@Serializable
data class ExportChampions(
  val list: Map<String, ExportChampion> = emptyMap()
)

@Serializable
data class ExportChampion (
  val id: String = "",
  val name: String = "",
  val infos: List<Pair<String, Int>>,
  val stats: List<Pair<String, Double>>,
  val lore: String = "",
  val spells: List<ExportChampionSpell> = emptyList()
)

@Serializable
data class ExportChampionSpell(
  val name: String="",
  val description: String=""
)