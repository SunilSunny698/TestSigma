package Elements;

import Visitors.PacketVisitor;

public class UDP implements Packet{
    public void accept(PacketVisitor visitor){
        visitor.visit(this);
    }
}
