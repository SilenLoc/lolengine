package view.ui

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class LolApplication : Application() {
    override fun start(stage: Stage) {
        val scene = Scene(uiStartUp(), 320.0, 240.0)
        stage.title = "Lol"
        stage.scene = scene
        stage.show()

        uiStartUp()
    }


}

fun main() {
    startUp()
    Application.launch(LolApplication::class.java)
}