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
    public Document clone(String type){
        PdfDoc res = this;
        if(type.toLowerCase().equals("deep")){
            res = new PdfDoc(this);
        }
        return res;
    }

    public String getData() {
        return data;
    }
    @Override
    public String toString() {
        return "PdfDoc [extension=" + extension + ", data=" + data + "]"+", name="+super.name;
    }
    
}
