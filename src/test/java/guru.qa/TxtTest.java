package guru.qa;

import com.codeborne.selenide.impl.FileHelper;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.FileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TxtTest {

    FileStream fileStream = new FileStream();

    @Test
    void simpleTxtTest() throws Exception{
        InputStream stream = fileStream.openFile("import_ou_csv.txt");
        /*String s;
        s = stream.toString();*/

        String s =  FileUtils.readFileToString(new File("src/test/resources/Hello.txt"), StandardCharsets.UTF_8);

        System.out.println(s);
                //new String(stream.readAllBytes(), "UTF-8");*/

        assertTrue(s.contains("Hello"));
    }
}
