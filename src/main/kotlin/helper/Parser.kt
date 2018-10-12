package helper

import model.Column
import model.Place
import java.io.File

class Parser {
    object Excel {
        @JvmStatic
        fun parse(excelFile: File, sheetNumber: Int = 0) {
            val workbook = helper.Excel.File.open(excelFile.absolutePath)
            val sheet = workbook.getSheetAt(sheetNumber)
            val iterator = sheet.iterator()
            try {
                while (iterator.hasNext()) {
                    val currentRow = iterator.next()
                    val place = Place(
                            currentRow.getCell(Column.ADDRESS).stringCellValue,
                            currentRow.getCell(Column.CITY).stringCellValue,
                            currentRow.getCell(Column.PROVINCE).stringCellValue,
                            currentRow.getCell(Column.PC).numericCellValue.toString()
                    )
                    println(place)
                }
            } catch (ex: Exception) {
                println("Error parsing Excel file: ${ex.message}")
            }
        }
    }
}