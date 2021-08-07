package DocumentPDF;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

public class CreateDocument {
    public static void main(String args[]) throws IOException {

        //Creating PDF document object
        PDDocument document = new PDDocument();

        for (int i=0; i<10; i++) {
            //Creating a blank page
            PDPage blankPage = new PDPage();

            //Adding the blank page to the document
            document.addPage( blankPage );
        }

        //Saving the document
        document.save("/home/document.pdf");
        System.out.println("PDF created");

        //Closing the document
        document.close();

    }
}
