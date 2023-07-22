package PrototypeDemo;

import Documents.PdfDoc;
import Documents.WordDoc;

public class Demo {

    public static void main(String[] args) {
        PdfDoc orgPDF = new PdfDoc("pdf1","This contains pdf format data");
        WordDoc orgDoc = new WordDoc("worddoc1","This contains word format data");

        PdfDoc copyPDF = (PdfDoc) orgPDF.clone();

        System.out.println("Original and copy pdf are same or not : "+orgPDF.equals(copyPDF));

    }
}
