import helper.Parser
import model.Place
import java.io.File

class Main {
    companion object {
        private const val DELAY_MILLIS = 500

        @JvmStatic
        fun main(args: Array<String>) {
            if (args.isNotEmpty()) {
                val srcExcelFilePath: String = args[0]
                var delay = DELAY_MILLIS
                if (args.size > 1) {
                    delay = args[1].toInt()
                }
                val srcExcelFile = File(srcExcelFilePath)
                Parser.Excel.parse(srcExcelFile)
            } else {
                printUsage()
            }
        }

        private fun printUsage() {
            println("addressGeolocate EXCEL_FILE_PATH [DELAY_IN_MILLIS = 500]\n" +
                    "\t     EXCEL_FILE_PATH: Path to the Parser file with the addresses\n" +
                    "\t     DELAY_IN_MILLIS: Elapsed time to wait between API calls\n")
        }
    }
}