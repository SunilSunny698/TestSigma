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
    public Document clone(String type){
        WordDoc res = this;
        if(type.toLowerCase().equals("deep")){
            res = new WordDoc(this);
        }
        return res;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WordDoc [extension=" + extension + ", data=" + data + "]"+", name="+super.name;
    }

    
    
}
