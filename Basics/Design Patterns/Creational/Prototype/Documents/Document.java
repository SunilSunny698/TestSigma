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
    public abstract Document clone();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof WordDoc)) return false;
        Document doc2 = (Document) object2;
        return doc2.name.equals(name);
    }
    
}