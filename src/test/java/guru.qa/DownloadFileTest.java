package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class DownloadFileTest {
    static final String PATH_TO_DOWN = "downloads";

    @AfterAll
    static void cleanDir() throws IOException {
        FileUtils.cleanDirectory(new File(PATH_TO_DOWN));
    }

    @Test
    void simpleDownload() throws Exception{
        Configuration.downloadsFolder = PATH_TO_DOWN;
        Selenide.open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadFile = $("#raw-url").download();

    }

}
