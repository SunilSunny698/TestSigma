package SearchTool;

public abstract class SearchProps {
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
    public String SearchTerm;
    public SortCriteria sortBy;
    public String Brand;
    public int size;
    public int ram;
    public ProcessorType processor; 
    public String Gender;
    public int price;
    public String offers;
}
