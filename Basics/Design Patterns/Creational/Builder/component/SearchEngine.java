package component;
import Builders.Filter;
public class SearchEngine {
    public enum SortCriteria {
        HightoLow,
        LowtoHigh
    };
    public enum ProcessorType {
        Mediatek,
        Snapdragon,
        IOS,
        Intel
    }
    private String SearchTerm;
    private SortCriteria sortBy;
    private String Brand;
    private int size;
    private int ram;
    private ProcessorType processor; 
    private String Gender;
    private int price;
    private String offers;
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
    public String getSearchTerm() {
        return SearchTerm;
    }
    public SortCriteria getSortBy() {
        return sortBy;
    }
    public String getBrand() {
        return Brand;
    }
    public int getSize() {
        return size;
    }
    public int getRam() {
        return ram;
    }
    public ProcessorType getProcessor() {
        return processor;
    }
    public String getGender() {
        return Gender;
    }
    public int getPrice() {
        return price;
    }
    public String getOffers() {
        return offers;
    }

    
    
}
