package Elements;

import Visitors.Visitor;

public class Company extends Client{
    public Company(String name, String email){
        this.name = name;
        this.email = email;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        
    }    
    
}
