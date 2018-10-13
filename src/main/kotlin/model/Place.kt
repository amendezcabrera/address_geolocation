package model

data class Place(
        val address: String,
        val city: String,
        val county: String,
        val country: String,
        val pc: String) {
    private val lat = 0.0
    private val lng = 0.0
    var location = Location(lat, lng)

    override fun toString(): String {
        return "Place: $address, $pc, $city ($county, $country)\n\tLatitude: ${location.lat}\n\tLongitude: ${location.lng}"
    }
}