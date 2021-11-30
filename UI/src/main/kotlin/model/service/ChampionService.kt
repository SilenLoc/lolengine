package model.service


import model.api.getNewestInfo
import model.champion.Champion
import model.json.ChampionJson
import model.json.ChampionsJson
import model.json.SpecificChampionJson


object ChampionService {
  private val newestChampions = getNewestInfo()

  private val championsJson: ChampionsJson
    get() = newestChampions.first

  private val specificChampions: Map<String, SpecificChampionJson.Champion>
    get() = newestChampions.second.associate {
      val champion = it.data.values.first()
      champion.id to champion
    }

  private val championsJsonList: List<ChampionJson>
    get() = championsJson.data.values.toList()

  val champions: List<Champion>
    get() = resolveChampionsFromJson()


  private fun resolveChampionsFromJson() = championsJsonList.map {
    println(specificChampions)
    val specificChampion = specificChampions[it.id]

    Champion(
      it.id,
      it.name,
      it.blurb,
      listOf(
        "Attack" to it.info.attack,
        "Defense" to it.info.defense,
        "Magic" to it.info.magic,
        "Difficulty" to it.info.difficulty
      ),
      listOf(
        "hp" to it.stats.hp,
        "hp per level" to it.stats.hpperlevel,
        "mp" to it.stats.mp,
        "mp per level" to it.stats.mpperlevel,
        "move speed" to it.stats.movespeed,
        "armor" to it.stats.armor,
        "armor per level" to it.stats.armorperlevel,
        "spell block" to it.stats.spellblock,
        "spell block per level" to it.stats.spellblockperlevel,
        "attack range" to it.stats.attackrange,
        "hp regeneration" to it.stats.hpregen,
        "hp regeneration per level" to it.stats.hpregenperlevel,
        "mp regeneration" to it.stats.mpregen,
        "mp regeneration per level" to it.stats.mpregenperlevel,
        "critical chance" to it.stats.crit,
        "critical chance per level" to it.stats.crit,
        "attack damage" to it.stats.attackdamage,
        "attack damage per level" to it.stats.attackdamageperlevel,
        "attack speed" to it.stats.attackspeed,
        "attack speed per level" to it.stats.attackspeedperlevel,
      ),
      specificChampion?.lore ?: "no lore found"
    )
  }
}
