package model.json

import kotlinx.serialization.Serializable

@Serializable
data class ChampionsJson(
  val type: String = "",
  val format: String = "",
  val version: String = "",
  val data: Map<String, ChampionJson>
)