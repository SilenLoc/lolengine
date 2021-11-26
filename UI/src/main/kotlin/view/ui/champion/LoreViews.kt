package view.ui

import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import javafx.scene.text.TextAlignment

class FullLoreView(lore: String) : AbstractLoreView(lore, "Full Lore:"), IIdentifiable{
  override val idAsString: String = "fulllore"

}

class BlurbView(blurb: String) : AbstractLoreView(blurb, "Blurb:") , IIdentifiable{
  override val idAsString: String = "blurb"
}



abstract class AbstractLoreView(lore: String, title: String) : VBox() {
  private val text = Text()
  private val titleLabel: Label = Label(title)

  init {
    text.wrappingWidth = 300.0
    text.textAlignment = TextAlignment.JUSTIFY;
    text.text = lore
    this.children.addAll(titleLabel, text)
  }

}