package model.service


import model.api.getNewestInfo
import model.champion.Champion
import model.champion.ChampionSpell
import model.json.ChampionJson
import model.json.ChampionsJson
import model.json.SpecificChampionJson


object ChampionService {
  private val newestChampions = getNewestInfo()

  private val championsJson: ChampionsJson
    get() = newestChampions.first

  private val specificChampions: Map<String, SpecificChampionJson.Champion>
    get() = newestChampions.second.associate { championJson ->
      val champion = championJson.data.values.first()
      champion.id to champion
    }

  private val championsJsonList: List<ChampionJson>
    get() = championsJson.data.values.toList()

  val champions: List<Champion>
    get() = resolveChampionsFromJson()


  private fun resolveChampionsFromJson() = championsJsonList.map { jsonC ->
    val specificChampion = specificChampions[jsonC.id]

    Champion(
      jsonC.id,
      jsonC.name,
      listOf(
        "Attack" to jsonC.info.attack,
        "Defense" to jsonC.info.defense,
        "Magic" to jsonC.info.magic,
        "Difficulty" to jsonC.info.difficulty
      ),
      listOf(
        "hp" to jsonC.stats.hp,
        "hp per level" to jsonC.stats.hpperlevel,
        "mp" to jsonC.stats.mp,
        "mp per level" to jsonC.stats.mpperlevel,
        "move speed" to jsonC.stats.movespeed,
        "armor" to jsonC.stats.armor,
        "armor per level" to jsonC.stats.armorperlevel,
        "spell block" to jsonC.stats.spellblock,
        "spell block per level" to jsonC.stats.spellblockperlevel,
        "attack range" to jsonC.stats.attackrange,
        "hp regeneration" to jsonC.stats.hpregen,
        "hp regeneration per level" to jsonC.stats.hpregenperlevel,
        "mp regeneration" to jsonC.stats.mpregen,
        "mp regeneration per level" to jsonC.stats.mpregenperlevel,
        "critical chance" to jsonC.stats.crit,
        "critical chance per level" to jsonC.stats.crit,
        "attack damage" to jsonC.stats.attackdamage,
        "attack damage per level" to jsonC.stats.attackdamageperlevel,
        "attack speed" to jsonC.stats.attackspeed,
        "attack speed per level" to jsonC.stats.attackspeedperlevel,
      ),
      specificChampion?.lore ?: "no lore found",
      specificChampion?.spells?.map {
        ChampionSpell(
          it.name,
          it.description,
          it.cooldown.joinToString(","),
          it.cooldownBurn,
          it.cost.joinToString(","),
          it.costType
        ) } ?: emptyList()
    )
  }
}
