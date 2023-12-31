package Filters;

import SearchTool.SearchEngine;
import SearchTool.SearchProps;

public class Filter extends SearchProps{

    public void setSearchTerm(String val){
        this.SearchTerm = val;
    }
    public void sortBy(SearchEngine.SortCriteria val){
        this.sortBy = val;
    }
    public void setBrand(String val){
        this.Brand = val;
        
    }
    public void setSize(int val){
        this.size = val;
        
    }

    public void setRam(int val){
        this.ram = val;
        
    }
    public void setProcessor(SearchEngine.ProcessorType val){
        this.processor = val;
    }
    
    public void setPrice(int val){
        this.price = val;
      
    }
    public void setGender(String val){
        this.Gender = val;
      
    }

    public void setOffers(String val){
        this.offers = val;
      
    }
    public SearchEngine applyfilter(){
        return new SearchEngine(SearchTerm,sortBy,Brand,size,ram,processor,Gender,price,offers);
    }
}
