package helper

import model.Column
import model.Place
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Workbook
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
                var place = read(currentRow)
                try {
                    place = Data.Retrieve.fromAPI(place)
                    println(place)
                    write(excelFile, workbook, currentRow, place)
                } catch (ex: Exception) {
                    println("${ex.message}")
                }
                Thread.sleep(delay)
            }
        }

        private fun read(currentRow: Row): Place {
            return Place(
                    currentRow.getCell(Column.ADDRESS).stringCellValue,
                    currentRow.getCell(Column.CITY).stringCellValue,
                    currentRow.getCell(Column.PROVINCE).stringCellValue,
                    currentRow.getCell(Column.COUNTRY).stringCellValue,
                    if (currentRow.getCell(Column.PC).cellType == CellType.STRING)
                        currentRow.getCell(Column.PC).stringCellValue else currentRow.getCell(Column.PC).numericCellValue.toInt().toString()
            )
        }

        private fun write(excelFile: File, workbook: Workbook, currentRow: Row, place: Place) {
            helper.Excel.Line.Box.write(currentRow, 7, place.location.lat.toString())
            helper.Excel.Line.Box.write(currentRow, 8, place.location.lng.toString())
            helper.Excel.File.write(workbook, excelFile.absolutePath)
        }
    }
}