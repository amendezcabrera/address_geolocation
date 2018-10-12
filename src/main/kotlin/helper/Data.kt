package helper

import model.Place
import java.net.URL

class Data {
    object Retrieve {
        private const val service = "https://nominatim.openstreetmap.org/search?format=json&"
        fun fromAPI(place: Place) {
            val request = "${service}q=${place.address}, ${place.city}, ${place.pc}, ${place.county}, ${place.country}".replace(" ", "%20")
            println("Request: $request")
            val jsonResponse: String = URL(request).readText()
            println(jsonResponse)
        }
    }
}