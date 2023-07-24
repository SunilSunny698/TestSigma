import AdvancedFilters.MobileFilters;
import Filters.Filter;
import SearchTool.SearchEngine;

public class App {
    public static void main(String[] args) {
        Filter f = new Filter();
        MobileFilters dir = new MobileFilters();
        dir.IOSMobileFilter(f);

        SearchEngine search = f.applyfilter();
        System.out.println("Showing results for :"+search.SearchTerm);
        System.out.println(search);
    }
}
