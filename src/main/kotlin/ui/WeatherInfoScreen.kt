package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.WeatherState
import utils.loadPicture
import java.util.*

@Composable
fun WeatherInfoScreen(data: WeatherState) {
    val time = remember { Calendar.getInstance().time }

    Row(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // location
        Column(
            modifier = Modifier.weight(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource("ic_location.png"),
                    contentDescription = "location image",
                    modifier = Modifier.size(48.dp),
                    tint = Color.White,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = data.name.orEmpty(),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Text(
                text = time.toString().substring(0, 10),
                modifier = Modifier.padding(start = 56.dp),
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource("ic_temperature.png"),
                    contentDescription = "location image",
                    modifier = Modifier.size(48.dp),
                    tint = Color.Unspecified,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = data.main?.temp?.toInt().toString(),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
        // weather image
        Column(
            modifier = Modifier.weight(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Image(
                bitmap = loadPicture(url = "http://openweathermap.org/img/w/${data.weather?.get(0)?.icon}.png"),
                modifier = Modifier.size(200.dp),
                contentDescription = "Weather Image",
                contentScale = ContentScale.Crop,
            )
            Text(
                text = data.weather?.get(0)?.main.orEmpty(),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
    }
}