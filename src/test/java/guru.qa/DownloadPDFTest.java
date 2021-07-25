package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;

public class DownloadPDFTest {


    @Test
    public void junitPDF()  throws Exception{
        Selenide.open("https://junit.org/junit5/docs/current/user-guide/");
        File downloadPDF = $(byText("PDF download")).download();
        PDF parsedPdf = new PDF(downloadPDF);
       //assertThat("1",true);
       // Assertions.assertEquals();

    }
}
