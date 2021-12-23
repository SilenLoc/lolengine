import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.job
import kotlinx.coroutines.runBlocking
import view.ui.uiStartUp

class LolApplication : Application() {
    companion object{
        var mainStage: Stage? = null
    }


    override fun start(stage: Stage) {
        mainStage = stage
        val scene = Scene(uiStartUp(), 1000.0, 800.0)
        stage.title = "Lol"
        stage.scene = scene
        stage.show()

        uiStartUp()
    }

}

fun main()  {
        Application.launch(LolApplication::class.java)
    }


