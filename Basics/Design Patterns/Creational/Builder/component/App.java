package component;

import Builders.Filter;
import Directors.Director;

public class App {
    public static void main(String[] args) {
        Filter f = new Filter();
        Director dir = new Director();
        dir.IOSMobileFilter(f);

        SearchEngine search = f.applyfilter();
        System.out.println("Showing results for :"+search.getSearchTerm());
    }
}
