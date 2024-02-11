package data

import data.model.WeatherState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import utils.Constants.API_KEY
import utils.Constants.BASE_URL

class WeatherApi {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getWeather(cityName: String): WeatherState =
        client.get("${BASE_URL}weather?q=${cityName}&appid=${API_KEY}").body()
}