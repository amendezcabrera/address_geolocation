package helper

import org.apache.poi.ss.usermodel.*
import java.io.FileInputStream
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

class Excel {
    object File {
        fun open(filePath: String): Workbook {
            return WorkbookFactory.create(FileInputStream(Paths.get(filePath).toFile()))
        }

        fun write(workbook: Workbook?, fileName: String) {
            var outputPath = Paths.get(fileName)
            try {
                Files.newOutputStream(outputPath).use {
                    workbook?.write(it)
                }
            } catch (e: IOException) {
                println(e.message)
                System.exit(0)
            }
        }
    }

    object Line {
        object Box {
            fun write(row: Row, cell: Int, value: String) {
                row.createCell(cell).setCellValue(value)
            }

            fun isEmpty(row: Row, cell: Int): Boolean {
                return row.getCell(cell).stringCellValue.equals("")
            }
        }

        fun remove(sheet: Sheet, row: Row) {
            return sheet.removeRow(row)
        }

        fun clear(row: Row) {
            for (cell: Cell in row) {
                cell.setCellValue("")
            }
        }
    }
}