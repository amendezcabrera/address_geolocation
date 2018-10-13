package helper

import com.google.gson.JsonParser
import model.Location
import model.Place
import java.net.URL

class Data {
    object Retrieve {
        private const val SERVICE = "https://nominatim.openstreetmap.org/search?format=json&"
        private const val LAT_KEY = "lat"
        private const val LNG_KEY = "lon"

        fun fromAPI(place: Place): Place {
            val request = "${SERVICE}q=${place.address}, ${place.city}, ${place.pc}, ${place.county}, ${place.country}".replace(" ", "%20")
            val jsonResponse: String = URL(request).readText()
            val jsonArray = JsonParser().parse(jsonResponse).asJsonArray
            if (!jsonArray.isJsonNull) {
                val lat = jsonArray[0].asJsonObject.get(LAT_KEY)
                val lng = jsonArray[0].asJsonObject.get(LNG_KEY)
                place.location = Location(lat.asDouble, lng.asDouble)
            }
            return place
        }
    }
}