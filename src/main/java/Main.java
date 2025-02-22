import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        PdfExtractor pdfExtractor = new PdfExtractor();
        //pdfExtractor.getTextFromPDF();

        System.out.println(pdfExtractor.getIbansFromPDF());
    }
}