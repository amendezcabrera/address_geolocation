import helper.Parser
import java.io.File
import java.io.FileNotFoundException

class Main {
    companion object {
        private const val DELAY_MILLIS: Long = 1000

        @JvmStatic
        fun main(args: Array<String>) {
            if (args.isNotEmpty()) {
                val srcExcelFilePath: String = args[0]
                var delay = DELAY_MILLIS
                if (args.size > 1) {
                    delay = args[1].toLong()
                }
                try {
                    val srcExcelFile = File(srcExcelFilePath)
                    Parser.Excel.parse(srcExcelFile, delay = delay)
                } catch (ex: FileNotFoundException) {
                    printFileNotFound(srcExcelFilePath)
                }
            } else {
                printUsage()
            }
        }

        private fun printUsage() {
            println("addressGeolocate EXCEL_FILE_PATH [DELAY_IN_MILLIS = 500]\n" +
                    "\t     EXCEL_FILE_PATH: Path to the Parser file with the addresses\n" +
                    "\t     DELAY_IN_MILLIS: Elapsed time to wait between API calls\n")
        }

        private fun printFileNotFound(path: String) {
            println("File cannot be found in '$path'")
        }
    }
}