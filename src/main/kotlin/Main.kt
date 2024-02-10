import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import ui.HomeScreen
import utils.Constants.APP_NAME

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = APP_NAME,
        icon = painterResource("weather_image.png"),
        resizable = false,
        state = WindowState(
            size = DpSize(800.dp, 600.dp),
            position = WindowPosition(alignment = Alignment.Center)
        )
    ) {
        Surface(
            color = Color(0xFFADD8E6),
            modifier = Modifier.fillMaxSize(),
        ) {
            HomeScreen()
        }
    }
}
