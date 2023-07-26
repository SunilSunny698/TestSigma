package Elements;

import Visitors.Visitor;

public class Bank extends Client{
    public Bank(String name,String email){
        this.name = name;
        this.email = email;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        
    }
    
}
