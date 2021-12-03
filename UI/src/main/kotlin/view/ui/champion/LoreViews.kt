package view.ui.champion

import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.scene.text.Text
import javafx.scene.text.TextAlignment

class FullLoreView(lore: String) : AbstractLoreView(lore, "Full Lore:"), IIdentifiable {
  override val idAsString: String = "fulllore"

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