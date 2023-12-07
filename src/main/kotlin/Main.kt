import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
var NNBD=NNSBD(5, 5)
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        mainBox()
    }
}
