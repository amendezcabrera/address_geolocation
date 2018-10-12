package helper

import model.Column
import model.Place
import org.apache.poi.ss.usermodel.CellType
import java.io.File

class Parser {
    object Excel {
        @JvmStatic
        fun parse(excelFile: File, sheetNumber: Int = 0, delay: Long) {
            val workbook = helper.Excel.File.open(excelFile.absolutePath)
            val sheet = workbook.getSheetAt(sheetNumber)
            val iterator = sheet.iterator()
            while (iterator.hasNext()) {
                val currentRow = iterator.next()
                val place = Place(
                        currentRow.getCell(Column.ADDRESS).stringCellValue,
                        currentRow.getCell(Column.CITY).stringCellValue,
                        currentRow.getCell(Column.PROVINCE).stringCellValue,
                        currentRow.getCell(Column.COUNTRY).stringCellValue,
                        if (currentRow.getCell(Column.PC).cellType == CellType.STRING)
                            currentRow.getCell(Column.PC).stringCellValue else currentRow.getCell(Column.PC).numericCellValue.toInt().toString()
                )
                try {
                    Data.Retrieve.fromAPI(place)
                } catch (ex: Exception) {
                    println("${ex.message}")
                }
                Thread.sleep(delay)
            }
        }
    }
}