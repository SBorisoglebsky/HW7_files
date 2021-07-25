package guru.qa;

import com.codeborne.xlstest.XLS;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.FileStream;

import java.io.InputStream;


public class XlsTest {

    FileStream fileStream = new FileStream();

    @Test
    void  simpleXlsTest() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("file_example_XLS_10.xls");
        XLS xlsFile = new XLS(stream);

        Assertions.assertEquals("Kathleen", xlsFile.excel.getSheetAt(0).getRow(4).getCell(1).getStringCellValue());
    }

    @Test
    void  apacheXlsTest() throws Exception {

        InputStream stream = fileStream.openFile("file_example_XLS_10.xls");
        HSSFWorkbook wb = new HSSFWorkbook (stream);

        Assertions.assertEquals("Kathleen", wb.getSheetAt(0).getRow(4).getCell(1).getStringCellValue());

    }
}
