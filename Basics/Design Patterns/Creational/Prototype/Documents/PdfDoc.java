package Documents;

public class PdfDoc extends Document{
    public final String extension = ".pdf" ;
    private String data;

    public PdfDoc(String name, String data) {
        super(name, data.getBytes().length);
        this.data = data;
    
    }
    public PdfDoc(PdfDoc target){
        super(target);
        this.data = target.data;
    }
    @Override
    public Document clone(){
        return new PdfDoc(this);
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof PdfDoc) || !super.equals(object2)) return false;
        PdfDoc doc2 = (PdfDoc) object2;
        return doc2.data.equals(data);
    }
}
