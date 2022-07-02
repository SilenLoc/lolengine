package view.ui.champion

import javafx.scene.control.Label
import javafx.scene.control.TabPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import model.champion.Champion
import model.champion.ChampionSpell
import kotlin.math.cos


class ChampionView(model: Champion) : BorderPane() {

    private val championInnerTabPane = TabPane()
    private val loreTab = LoreTab()
    private val infoTab = InfoTab()
    private val statsTab = StatsTab()
    private val spellsTab = SpellsTab()


    init {
        loreTab.content = MainLoreView(model.lore)
        infoTab.content = ChampionInfoView(model.infos)
        statsTab.content = ChampionStatsView(model.stats)
        spellsTab.content = ChampionSpellView(model.spells)


        championInnerTabPane.tabs.addAll(loreTab, infoTab, statsTab, spellsTab)

        this.top = championInnerTabPane
    }

    fun selectInnerTabWithId(id: String) {
        championInnerTabPane.selectionModel.select(championInnerTabPane.tabs.find { it.id == id })
    }

}

class ChampionStatsView(stats: List<Pair<String, Double>>) : VBox() {

    init {
        val infoViews = stats.map { (title, double) ->
            Label("$title: $double")
        }

        this.children.addAll(infoViews)
    }
}

class MainLoreView(fullLore: String) : BorderPane() {

    init {
        this.center = FullLoreView(fullLore)
    }
}

class ChampionInfoView(infos: List<Pair<String, Int>>) : VBox() {

    init {
        val infoViews = infos.map { (title, int) ->
            Label("$title: $int")
        }
        this.children.addAll(infoViews)
    }
}

class ChampionSpellView(infos: List<ChampionSpell>) : TabPane() {

    init {
        val infoViews = infos.map { (title, description, cooldown, cooldownBurn, cost, costType) ->
            val tab = SpellTab(title)
            tab.content = SpellView(title, description, cooldown, cooldownBurn, cost, costType)
            tab
        }
        this.tabs.addAll(infoViews)
    }
}


class SpellView(
    name: String,
    description: String,
    cooldown: String = "",
    cooldownBurn: String = "",
    cost: String = "",
    costType: String = ""
) : VBox() {

    private val nameD = "name: "
    private val descD = "description: "
    private val cooldownD = "cooldowns: "
    private val cooldownBrunD = "cooldown burn: "
    private val costD = "costs: "
    private val costTypeD = "costType: "

    init {
        initWithAll(
            listOf(
                Pair(nameD, name),
                Pair(descD, description),
                Pair(cooldownD, cooldown),
                Pair(cooldownBrunD, cooldownBurn),
                Pair(costD, cost),
                Pair(costTypeD, costType)
            )
        )
    }

    private fun initWithAll(all: Collection<Pair<String, String>>) = this.children.addAll(
        all.map { HBox(Label(it.first), Label(it.second)) }
    )
}




