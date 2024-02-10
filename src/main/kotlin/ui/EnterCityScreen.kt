package ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import utils.Constants.BACKGROUND_COLOR

@Composable
fun EnterCityScreen(
    onClickToAcceptButton: (city: String) -> Unit,
) {
    val city = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Card(
            modifier = Modifier.width(350.dp),
            shape = RoundedCornerShape(20.dp),
            backgroundColor = Color.White,
            elevation = 16.dp,
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text("Lütfen Şehir Giriniz", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = city.value,
                    onValueChange = { city.value = it },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        focusedIndicatorColor = BACKGROUND_COLOR,
                        cursorColor = BACKGROUND_COLOR,
                        unfocusedIndicatorColor = BACKGROUND_COLOR,
                    ),
                    shape = RoundedCornerShape(8.dp),
                    singleLine = true,
                    placeholder = { Text(text = "Şehriniz") },
                    textStyle = TextStyle(fontSize = 16.sp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        onClickToAcceptButton(city.value)
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = BACKGROUND_COLOR),
                ) {
                    Text("Onayla", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
