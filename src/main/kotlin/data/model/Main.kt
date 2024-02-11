package data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Main(
    @SerializedName("feels_like")
    val feels_like: Double? = null,
    @SerializedName("humidity")
    val humidity: Int? = null,
    @SerializedName("pressure")
    val pressure: Int? = null,
    @SerializedName("temp")
    val temp: Double? = null,
    @SerializedName("temp_max")
    val temp_max: Double? = null,
    @SerializedName("temp_min")
    val temp_min: Double? = null
)