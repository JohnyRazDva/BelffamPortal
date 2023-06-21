package com.bellfam.website.service.pdf;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

/**
 * @author Eugene Petrov
 */

@Service
public class PdfFileRedactor {
    public final static String PDF_PATTERN_FILE_SOURCE = "src/main/resources/letter.pdf";
    public final static String PDF_FILE_SOURCE = "src/main/resources/Malfunction_letter.pdf";
    public final static String LETTER_COMPANY_INFO_PREFIX_TO = "To:";
    public final static String LETTER_COMPANY_PRE_LETTER_STRING = "To whom it may concern:";
    public final static int LETTER_COMPANY_PRE_LETTER_STRING_MARGIN_TOP = 40;
    public final static int LETTER_MARGIN_LEFT = 21;
    public final static int LETTER_FONT_SIZE = 10;
    public final static int LETTER_MARGIN_TOP_DATE = 120;
    public final static int LETTER_MARGIN_TOP_PREFIX_TO = 0;
    public final static int LETTER_MARGIN_TOP_COMPANY_NAME = -10;
    public final static int LETTER_MARGIN_TOP_COMPANY_MAIN_ADDRESS = -10;
    public final static int LETTER_MARGIN_TOP_COMPANY_SECOND_ADDRESS = -10;
    public final static int LETTER_MARGIN_TOP = 10;
    public final static String LETTER_PART_1 = "This letter is a confirmation that BELLFAM ELD system used by ";
    public final static String LETTER_PART_2 = " with ";
    public final static String LETTER_PART_3 = " is currently in malfunction. An unidentified problem doesn’t allow the ELD device to function properly. An unidentified problem doesn’t allow the ELD device to function properly. The driver can use paper logs in the meantime (up to 8 days). We are aware of the issue and working on resolving it. A new device is on its way to the customer.";


    //TODO  something with null source!
    public String getResultFileSource(String companyName, String companyMainAddress, String companySecondAddress, String driverInfo, String date) throws IOException {
        String resultFileSource = "null";
        if (createPdfFile(companyName, companyMainAddress, companySecondAddress, driverInfo, date)) {
            resultFileSource = PDF_FILE_SOURCE;
        }
        return resultFileSource;
    }

    private boolean createPdfFile(String companyName, String companyMainAddress, String companySecondAddress, String driverInfo, String date) throws IOException {
        PdfDocument pdfDocument = new PdfDocument(new PdfReader(PDF_PATTERN_FILE_SOURCE),
                new PdfWriter(PDF_FILE_SOURCE));
        PdfPage page = pdfDocument.getPage(1);
        PageSize pageSize = new PageSize(page.getPageSize());
        Document document = new Document(pdfDocument, pageSize);
        document = addDataToDocument(document, companyName, companyMainAddress, companySecondAddress, driverInfo, date);
        pdfDocument.close();
        return true;
    }

    private Document addDataToDocument(Document document, String companyName, String companyMainAddress, String companySecondAddress, String driverInfo, String date) throws IOException {
        PdfFont font = PdfFontFactory.createFont("Arialn.ttf", PdfEncodings.IDENTITY_H);


        //add date  to document
        Paragraph dateParagraph = new Paragraph(date)
                .setFont(font)
                .setFontSize(LETTER_FONT_SIZE)
                .setMarginLeft(LETTER_MARGIN_LEFT)
                .setMarginTop(LETTER_MARGIN_TOP_DATE);
        document.add(dateParagraph);

        //add prefix To:  to document
        Paragraph prefixToParagraph = new Paragraph(LETTER_COMPANY_INFO_PREFIX_TO)
                .setFont(font)
                .setFontSize(LETTER_FONT_SIZE)
                .setMarginLeft(LETTER_MARGIN_LEFT)
                .setMarginTop(LETTER_MARGIN_TOP_PREFIX_TO);
        document.add(prefixToParagraph);

        //add company name to document
        Paragraph companyNameParagraph = new Paragraph(companyName)
                .setFont(font)
                .setFontSize(LETTER_FONT_SIZE)
                .setMarginLeft(LETTER_MARGIN_LEFT)
                .setMarginTop(LETTER_MARGIN_TOP_COMPANY_NAME);
        document.add(companyNameParagraph);

        //add company main address to document
        Paragraph companyMainAddressParagraph = new Paragraph(companyMainAddress)
                .setFont(font)
                .setFontSize(LETTER_FONT_SIZE)
                .setMarginLeft(LETTER_MARGIN_LEFT)
                .setMarginTop(LETTER_MARGIN_TOP_COMPANY_MAIN_ADDRESS);
        document.add(companyMainAddressParagraph);

        //add company second address to document
        Paragraph companySecondAddressParagraph = new Paragraph(companySecondAddress)
                .setFont(font)
                .setFontSize(LETTER_FONT_SIZE)
                .setMarginLeft(LETTER_MARGIN_LEFT)
                .setMarginTop(LETTER_MARGIN_TOP_COMPANY_SECOND_ADDRESS);
        document.add(companySecondAddressParagraph);

        //add pre letter string to document
        Paragraph preLetterStringParagraph = new Paragraph(LETTER_COMPANY_PRE_LETTER_STRING)
                .setFont(font)
                .setFontSize(LETTER_FONT_SIZE)
                .setMarginLeft(LETTER_MARGIN_LEFT)
                .setMarginTop(LETTER_COMPANY_PRE_LETTER_STRING_MARGIN_TOP);
        document.add(preLetterStringParagraph);

        //add  letter  to document
        Paragraph letterParagraph = new Paragraph(LETTER_PART_1 + driverInfo + LETTER_PART_2 + companyName + LETTER_PART_3)
                .setFont(font)
                .setFontSize(LETTER_FONT_SIZE)
                .setMarginLeft(LETTER_MARGIN_LEFT)
                .setMarginTop(LETTER_MARGIN_TOP);
        document.add(letterParagraph);

        document.close();
        return document;
    }

    //TODO exceptions and delete serr
    public void deletePdfFile(){
        Path path = FileSystems.getDefault().getPath(PDF_FILE_SOURCE);
        try {
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
