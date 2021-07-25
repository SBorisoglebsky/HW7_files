package guru.qa;

import com.codeborne.pdftest.PDF;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;
import pages.FileStream;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PDFTest {
    FileStream fileStream = new FileStream();

    @Test
    void simplePDFTest() throws IOException {
        InputStream stream = fileStream.openFile("file-sample_pdf.pdf");
        PDF parsedPdf = new PDF(stream);

        assertThat(parsedPdf.producer).contains("LibreOffice 4.2");

    }

    @Test
    void apachePDFTEst() throws IOException {
        InputStream stream = fileStream.openFile("file-sample_pdf.pdf");
        PDDocument doc = PDDocument.load(stream);
        String content = new PDFTextStripper().getText(doc);

        assertTrue(content.contains("Lorem ipsum dolor"));

    }

}
