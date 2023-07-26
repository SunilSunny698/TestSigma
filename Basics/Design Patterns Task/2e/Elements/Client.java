package Elements;

import Visitors.Visitor;

public abstract class Client {
    public String name;
    public String email;
    public abstract void accept(Visitor visitor);
}
