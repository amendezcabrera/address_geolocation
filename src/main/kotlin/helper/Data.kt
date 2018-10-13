package helper

import com.google.gson.JsonParser
import model.Location
import model.Place
import java.net.URL

class Data {
    object Retrieve {
        private const val service = "https://nominatim.openstreetmap.org/search?format=json&"
        fun fromAPI(place: Place): Place {
            val request = "${service}q=${place.address}, ${place.city}, ${place.pc}, ${place.county}, ${place.country}".replace(" ", "%20")
            val jsonResponse: String = URL(request).readText()
            val jsonArray = JsonParser().parse(jsonResponse).asJsonArray
            if (!jsonArray.isJsonNull) {
                val lat = jsonArray[0].asJsonObject.get("lat")
                val lng = jsonArray[0].asJsonObject.get("lon")
                place.location = Location(lat.asDouble, lng.asDouble)
            }
            return place
        }
    }
}