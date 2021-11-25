package view.ui

import javafx.scene.control.Label
import javafx.scene.control.Tab
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import javafx.scene.text.TextAlignment
import model.champion.Champion
import model.json.ChampionJson

class ChampionTab(model: Champion) : Tab() {
    init {
        this.text = model.name
        this.content = ChampionView(model)
    }
}


class ChampionView(model: Champion) : BorderPane() {

    init {
        this.center = ChampionInfoView(model.infos)
        this.bottom = MetaView(model.blurb)
    }


}

class ChampionInfoView(infos: List<Pair<String, Int>>): VBox(){

    init {
        val infoViews = infos.map{ (title,int) ->
            Label("$title: $int")
        }
        this.children.addAll(infoViews)
    }
}

class MetaView(meta: String) : VBox() {
    private val text = Text()
    private val title = Label("Blurb:")

    init {
        text.wrappingWidth = 300.0
        text.textAlignment = TextAlignment.JUSTIFY;
        text.text = meta
        children.addAll(title, text)
    }
}