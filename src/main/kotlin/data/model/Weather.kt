package data.model


import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("cod")
    val cod: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("main")
    val main: Main? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("weather")
    val weatherState: List<WeatherState?>? = null,
    @SerializedName("wind")
    val wind: Wind? = null
)