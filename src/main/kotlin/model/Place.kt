package model

data class Place(
        private val address: String,
        private var cp: String,
        val city: String,
        val province: String,
        val lat: Double = 0.0,
        val lng: Double = 0.0) {
    val location = Location(lat, lng)

    override fun toString(): String {
        return "Place: $address, $cp, $city ($province)\n\tLatitude: $lat\n\tLongitude: $lng"
    }
}