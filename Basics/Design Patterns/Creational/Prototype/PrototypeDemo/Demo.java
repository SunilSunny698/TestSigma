package PrototypeDemo;

import Documents.PdfDoc;
import Documents.WordDoc;

public class Demo {

    public static void main(String[] args) {
        PdfDoc orgPDF = new PdfDoc("pdf1","This contains pdf format data");
        WordDoc orgDoc = new WordDoc("worddoc1","This contains word format data");

        PdfDoc copyPDF = (PdfDoc) orgPDF.clone("deep");
        copyPDF.name = "pdf2";

        WordDoc copyDoc = (WordDoc) orgDoc.clone("shallow");
        copyDoc.name = "worddoc2";

        System.out.println("Deep copy demo");
        System.out.println(orgPDF);
        System.out.println(copyPDF+"\n");

        System.out.println("Shallow copy demo");
        System.out.println(orgDoc);
        System.out.println(copyDoc);

    }
}
