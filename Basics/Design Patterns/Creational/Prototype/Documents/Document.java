package Documents;
public abstract class Document{
    public String name;
    public int size;
    
    
    
    public Document(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public Document(Document target){
        if(target!=null){
    
            this.name = target.name;
            this.size = target.size;
        }
    }
    public abstract Document clone(String type);

    
    
}