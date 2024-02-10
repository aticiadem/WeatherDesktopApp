package ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun HomeScreen() {
    val screenState = remember { mutableStateOf(0) } // 0 -> EnterCityScreen, 1 -> WeatherInfoScreen
    val showEmptyCityDialog = remember { mutableStateOf(false) }

    if (screenState.value == 1) {
        WeatherInfoScreen()
    } else if (screenState.value == 0) {
        EnterCityScreen(
            onClickToAcceptButton = {
                if (it.isNotEmpty()) {
                    // TODO: Arama islemi yapacagiz.
                    screenState.value = 1
                } else {
                    showEmptyCityDialog.value = true
                }
            }
        )
    }

    if (showEmptyCityDialog.value) {
        EmptyCityDialog(showEmptyCityDialog = showEmptyCityDialog)
    }
}

@Composable
private fun EmptyCityDialog(
    showEmptyCityDialog: MutableState<Boolean>,
) {
    Dialog(
        onDismissRequest = {
            showEmptyCityDialog.value = false
        },
        content = {
            Box(contentAlignment = Alignment.Center) {
                Text("Lütfen Geçerli Bir Şehir Giriniz!", fontSize = 18.sp, color = Color.White)
            }
        }
    )
}