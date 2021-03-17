import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class Demo {
    public static void main(String [] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("test");
        int rowNumber = 0;
        Row row = sheet.createRow(rowNumber++);
        int cellNumber = 0;
        Cell cell = row.createCell(cellNumber++);
        cell.setCellValue("Decimal");
        cell = row.createCell(cellNumber++);
        cell.setCellValue(2.5);

        cellNumber = 0;
        row = sheet.createRow(rowNumber++);
        cell = row.createCell(cellNumber++);
        cell.setCellValue("Text");
        cell = row.createCell(cellNumber++);
        cell.setCellValue("Text data");
        FileOutputStream outputStream = new FileOutputStream("template/test1.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        System.out.println("done!");

        readExcelFile();
    }

    private static void readExcelFile() throws IOException {
        FileInputStream inputStream = new FileInputStream("template/test2.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.STRING) {
                    System.out.println("STRING => " + cell.getStringCellValue());
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        System.out.println("DATE => " + simpleDateFormat.format(cell.getDateCellValue()));
                    } else {
                        System.out.println("NUMERIC => " + cell.getNumericCellValue());
                    }
                } else if (cell.getCellType() == CellType.FORMULA) {
                    System.out.println("FORMULA => " + "Formula: " + cell.getCellFormula());
                } else {
                    System.out.println("Other cell type...");
                }
            }
        }
    }
}
