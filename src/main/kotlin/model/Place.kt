package model

data class Place(
        val address: String,
        val city: String,
        val county: String,
        val country: String,
        val pc: String,
        val lat: Double = 0.0,
        val lng: Double = 0.0) {
    val location = Location(lat, lng)

    override fun toString(): String {
        return "Place: $address, $pc, $city ($county, $country)\n\tLatitude: $lat\n\tLongitude: $lng"
    }
}