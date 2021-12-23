package model.service.championexport

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import model.champion.Champion
import java.io.File

object ChampionExportService {

  fun exportChampions(file: File, champions: List<Champion>) {
    val json = Json { }
    val export = ExportChampions(champions.mapToExportChampions())

    file.printWriter().use { out ->
      out.println(json.encodeToString(export))
    }
  }


  private fun List<Champion>.mapToExportChampions(): Map<String, ExportChampion> {
    return this.map {
      println("exporting ${it.name}")
      ExportChampion(
        it.id,
        it.name,
        it.infos,
        it.stats,
        it.lore,
        it.spells.map { spells ->
          ExportChampionSpell(spells.name, spells.description)
        }
      )
    }.associateBy { it.id }
  }


}