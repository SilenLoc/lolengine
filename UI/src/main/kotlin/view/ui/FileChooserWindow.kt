package view.ui


import javafx.stage.FileChooser
import java.io.File

object FileChooserWindow {

  fun save(): File? {
    val fileChooser = FileChooser()

      fileChooser.extensionFilters.addAll(
      FileChooser.ExtensionFilter("Json", "*.json")
    )
    fileChooser.initialFileName = "champions.txt"

    return fileChooser.showSaveDialog(LolApplication.mainStage)
  }

}