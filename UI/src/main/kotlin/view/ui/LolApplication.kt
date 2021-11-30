package view.ui

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.job
import kotlinx.coroutines.runBlocking

class LolApplication : Application() {
    override fun start(stage: Stage) {
        val scene = Scene(uiStartUp(), 320.0, 240.0)
        stage.title = "Lol"
        stage.scene = scene
        stage.show()

        uiStartUp()
    }

}

fun main()  {
        Application.launch(LolApplication::class.java)
    }


