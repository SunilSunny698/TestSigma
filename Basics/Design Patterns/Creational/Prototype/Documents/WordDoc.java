package Documents;

public class WordDoc extends Document{
    public final String extension = ".doc";
    private String data;
    public WordDoc(String name,String data) {
        super(name, data.getBytes().length);
        this.setData(data);

    }

    public WordDoc(WordDoc target){
        super(target);
        this.data = target.data;
    }
    
    @Override
    public Document clone(){
        return new WordDoc(this);
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof WordDoc) || !super.equals(object2)) return false;
        WordDoc doc2 = (WordDoc) object2;
        return doc2.data.equals(data);
    }
    
}
