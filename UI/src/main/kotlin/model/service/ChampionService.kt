package model.service

import model.champion.Champion
import model.json.ChampionJson
import model.json.ChampionsJson
import view.ui.championsString

object ChampionService {
    val championsJson: ChampionsJson = ChampionLoader.loadChampions(championsString)
    val championsJsonList: List<ChampionJson> = championsJson.data.values.toList()
    val champions: List<Champion> = resolveChampionsFromJson()


    private fun resolveChampionsFromJson() = championsJsonList.map {
        Champion(
            it.id,
            it.name,
            it.blurb,
            listOf(
                "Attack" to it.info.attack,
                "Defense" to it.info.defense,
                "Magic" to it.info.magic,
                "Difficulty" to it.info.difficulty
            )
        )
    }
}