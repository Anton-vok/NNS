import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
var BD=NNSBD()
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        mainBox()
    }
}
