package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {
    private File file;
    private static XSSFSheet sheet;

    public FileReader(String fileName, String sheetName) throws IOException {
        file = new File("src/test/resources/testData/" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook WB = new XSSFWorkbook(inputStream);
        sheet = WB.getSheet(sheetName);
    }

    public String getData(int RN, int CN) {
        DataFormatter formatter = new DataFormatter();
        String field = formatter.formatCellValue(sheet.getRow(RN).getCell(CN));
        return field;
    }
}
