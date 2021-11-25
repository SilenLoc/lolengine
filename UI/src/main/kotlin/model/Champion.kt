package lolmodel

import kotlinx.serialization.Serializable

@Serializable
data class Champion(
  val version: String= "",
  val id: String = "",
  val key: Int = 0,
  val name: String = "",
  val title: String = "",
  val blurb: String = "",

  val info: ChampionInfo,

  val image: ChampionImage,

  val tags: List<String> = emptyList(),

  val partype: String = "",

  val stats: ChampionStats

) {


}
@Serializable
data class ChampionStats(
  val hp: Double = 0.0,
  val hpperlevel: Double = 0.0,
  val mp: Double = 0.0,
  val mpperlevel: Double = 0.0,
  val movespeed: Double = 0.0,
  val armor: Double = 0.0,
  val armorperlevel: Double = 0.0,
  val spellblock: Double = 0.0,
  val spellblockperlevel: Double = 0.0,
  val attackrange: Double = 0.0,
  val hpregen: Double = 0.0,
  val hpregenperlevel: Double = 0.0,
  val mpregen: Double = 0.0,
  val mpregenperlevel: Double = 0.0,
  val crit: Double = 0.0,
  val critperlevel: Double = 0.0,
  val attackdamage: Double = 0.0,
  val attackdamageperlevel: Double = 0.0,  val attackspeedperlevel: Double = 0.0,
  val attackspeed: Double = 0.0,
)

@Serializable
data class ChampionImage(
  val full: String = "",
  val sprite: String = "",
  val group: String = "",
  val x: Int = 0,
  val y: Int = 0,
  val w: Int = 48,
  val h: Int = 48
)


@Serializable
class ChampionInfo {
  val attack: Int = 0
  val defense: Int = 0
  val magic: Int = 0
  val difficulty: Int = 0
}
