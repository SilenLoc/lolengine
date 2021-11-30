package view.ui.menu

import javafx.scene.Node
import javafx.scene.layout.HBox

class Menu(content: Collection<Node>): HBox() {


  init {
    this.children.addAll(content)
  }

}