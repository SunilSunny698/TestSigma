package AdvancedFilters;
import Filters.*;
import SearchTool.SearchEngine;
public class MobileFilters {
    public void IOSMobileFilter(Filter filter){
        filter.setSearchTerm("Apple mobile");
        filter.setBrand("Apple");
        filter.setProcessor(SearchEngine.ProcessorType.IOS);
    }
    public void AndroidMobileFilter(Filter filter){
        filter.setSearchTerm("Android mobile");
        filter.setProcessor(SearchEngine.ProcessorType.Snapdragon);
        filter.setBrand("Realme|Redmi|Oppo");
    }
}
