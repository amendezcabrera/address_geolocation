package model

data class Place(
        val address: String,
        val city: String,
        val county: String,
        val country: String,
        val pc: String,
        var location: Location = Location()) {

    override fun toString(): String {
        return "Place: $address, $pc, $city ($county, $country)\n\tLatitude: ${location.lat}\n\tLongitude: ${location.lng}"
    }
}