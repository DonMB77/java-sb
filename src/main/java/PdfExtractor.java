import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PdfExtractor {

    private String text;
    private File file;

    public PdfExtractor() throws IOException {
        file = new File("Testdata_Invoices.pdf");
        PDDocument document = PDDocument.load(file);

        PDFTextStripper pdfStripper = new PDFTextStripper();
        this.text = pdfStripper.getText(document);

        document.close();
    }

    public void getTextFromPDF() {
        System.out.println(text);
    }

    public ArrayList<String> getIbansFromPDF() throws IOException {
        ArrayList<String> outListWithIbans = new ArrayList<>();
        String matchIbanString = "IBAN:";
        String tempStringHolder;
        String tempStringLine;

        Scanner scanner = new Scanner(text);

        while (scanner.hasNextLine())
        {
            tempStringLine = scanner.nextLine();
            if(tempStringLine.contains(matchIbanString)) {
                System.out.println(tempStringLine);
                int indexStart = tempStringLine.indexOf("IBAN") + 5;
                int indexEnd = tempStringLine.indexOf("SWIFT");
                tempStringHolder = tempStringLine.substring(indexStart, indexEnd);
                tempStringHolder = tempStringHolder.strip();
                outListWithIbans.add(tempStringHolder);
            }
        }
        scanner.close();
        return outListWithIbans;
    }
}
