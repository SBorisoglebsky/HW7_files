package guru.qa;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class ZipTest {

    @Test
    void zipTest() throws IOException, ZipException {

        String expectedData = "Привет!";

        ZipFile file = new ZipFile("src/test/resources/Hello.zip");
        file.setPassword("12345");
        file.extractAll("./src/test/resources/unzip");


        String s = FileUtils.readFileToString(new File("./src/test/resources/unzip/Hello.txt"), StandardCharsets.UTF_8);

        assertThat("Hello", containsString("Hello"));

    }
}
