package Excel.utility;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {

    public String path;
    public FileOutputStream fileOut = null;
    public Workbook workbook = null;
    public Sheet sheet = null;
    public Row row = null;
    public Cell cell = null;

    // ✅ Updated Constructor to accept Workbook
    public Xls_Reader(String path, Workbook workbook) {
        this.path = path;
        this.workbook = workbook;
    }

    // Get row count
    public int getRowCount(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1)
            return 0;
        else {
            sheet = workbook.getSheetAt(index);
            int number = sheet.getLastRowNum() + 1;
            return number;
        }
    }

    // Get cell data
    public String getCellData(String sheetName, String colName, int rowNum) {
        try {
            if (rowNum <= 0)
                return "";

            int index = workbook.getSheetIndex(sheetName);
            if (index == -1)
                return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);

            int colNum = -1;
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    colNum = i;
            }
            if (colNum == -1)
                return "";

            row = sheet.getRow(rowNum - 1);
            if (row == null)
                return "";
            cell = row.getCell(colNum);

            if (cell == null)
                return "";

            if (cell.getCellType() == CellType.STRING)
                return cell.getStringCellValue();
            else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
                String cellText = String.valueOf(cell.getNumericCellValue());
                return cellText;
            } else if (cell.getCellType() == CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());

        } catch (Exception e) {
            e.printStackTrace();
            return "row " + rowNum + " or column " + colName + " does not exist in xls";
        }
    }

    // Set cell data
    public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
        try {
            if (rowNum <= 0)
                return false;

            int index = workbook.getSheetIndex(sheetName);
            if (index == -1)
                return false;

            sheet = workbook.getSheetAt(index);

            row = sheet.getRow(0);
            int colNum = -1;
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
                    colNum = i;
                    break;
                }
            }
            if (colNum == -1)
                return false;

            sheet.autoSizeColumn(colNum);

            row = sheet.getRow(rowNum - 1);
            if (row == null)
                row = sheet.createRow(rowNum - 1);

            cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);

            cell.setCellValue(data);

            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Close the workbook
    public void closeWorkbook() {
        try {
            if (workbook != null)
                workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}