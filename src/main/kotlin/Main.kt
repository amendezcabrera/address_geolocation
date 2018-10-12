import model.Place

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val place = Place("7700 3rd Street", "11419", "NY", "NY")
            println(place.toString())
        }
    }
}