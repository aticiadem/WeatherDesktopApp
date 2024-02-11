package ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import data.WeatherApi
import data.model.WeatherState
import kotlinx.coroutines.*

@Composable
fun HomeScreen() {
    // 0 -> EnterCityScreen, 1 -> WeatherInfoScreen, 2 -> LoadingScreen, 3 -> ErrorScreen, 4 -> fetchData
    val screenState = remember { mutableStateOf(0) }
    val cityName = remember { mutableStateOf("") }
    val showEmptyCityDialog = remember { mutableStateOf(false) }
    val errorText = remember { mutableStateOf("") }
    val data = remember { mutableStateOf(WeatherState()) }

    when (screenState.value) {
        0 -> {
            EnterCityScreen(
                onClickToAcceptButton = {
                    if (it.isNotEmpty()) {
                        screenState.value = 4
                        cityName.value = it
                    } else {
                        showEmptyCityDialog.value = true
                    }
                }
            )
        }

        1 -> WeatherInfoScreen(data.value)

        2 -> LoadingScreen()

        3 -> ErrorScreen(errorText.value)

        4 -> {
            LaunchedEffect(true) {
                fetchData(
                    city = cityName.value,
                    onSuccess = {
                        screenState.value = 1
                        data.value = it
                    },
                    onLoading = {
                        if (it) {
                            screenState.value = 2
                        }
                    },
                    onError = {
                        screenState.value = 3
                        errorText.value = it
                    }
                )
            }
        }
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

@OptIn(DelicateCoroutinesApi::class)
private suspend fun fetchData(
    city: String,
    onSuccess: (WeatherState) -> Unit,
    onError: (String) -> Unit,
    onLoading: (Boolean) -> Unit
) {
    GlobalScope.launch {
        try {
            onLoading.invoke(true)
            val data = WeatherApi().getWeather(city)
            onLoading.invoke(false)
            onSuccess.invoke(data)
        } catch (e: Exception) {
            onError(e.localizedMessage)
        }
    }
}
