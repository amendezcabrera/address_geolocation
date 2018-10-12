package model

import com.google.gson.JsonParser

data class Place(
        private val address: String = "",
        private var cp: String = "",
        val city: String = "",
        val province: String = "") {
    var location: Location = Location(lat, lng)
    val lat: Double
        get() {
            return location.lat
        }
    val lng: Double
        get() {
            return location.lng
        }

    override fun toString(): String {
        return "Place: $address, $cp, $city ($province)\n\tLatitude: $lat\n\tLongitude: $lng"
    }
}