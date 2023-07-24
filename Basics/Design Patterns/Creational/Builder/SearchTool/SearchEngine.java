package SearchTool;
public class SearchEngine extends SearchProps{
    
    public SearchEngine(String SearchTerm,SortCriteria sortBy,String Brand,int size,int ram,ProcessorType processor,String Gender,int price,String offers){
        this.SearchTerm = SearchTerm;
        this.sortBy = sortBy;
        this.Brand = Brand;
        this.size = size;
        this.ram = ram;
        this.processor = processor;
        this.Gender = Gender;
        this.price = price;
        this.offers = offers;
    }
    @Override
    public String toString() {
        return "SearchEngine [SearchTerm=" + SearchTerm + ", sortBy=" + sortBy + ", Brand=" + Brand + ", size=" + size
                + ", ram=" + ram + ", processor=" + processor + ", Gender=" + Gender + ", price=" + price + ", offers="
                + offers + "]";
    } 
}
