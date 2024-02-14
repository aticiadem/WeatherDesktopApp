package data

import data.model.WeatherState
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import utils.Constants.API_KEY
import utils.Constants.BASE_URL

class WeatherApi {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getWeather(cityName: String): WeatherState {
        val json = Json { ignoreUnknownKeys = true }
        val response = client.get("${BASE_URL}weather?q=${cityName}&appid=${API_KEY}&units=metric")
        return json.decodeFromString(response.bodyAsText())
    }
}