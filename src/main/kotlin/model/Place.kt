package model

data class Place(
        private val address: String,
        val city: String,
        val province: String,
        private var pc: String,
        val lat: Double = 0.0,
        val lng: Double = 0.0) {
    val location = Location(lat, lng)

    override fun toString(): String {
        return "Place: $address, $pc, $city ($province)\n\tLatitude: $lat\n\tLongitude: $lng"
    }
}