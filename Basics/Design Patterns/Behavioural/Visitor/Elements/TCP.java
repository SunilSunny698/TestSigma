package Elements;

import Visitors.PacketVisitor;

public class TCP implements Packet{
    public void accept(PacketVisitor visitor){
        visitor.visit(this);
    }    
}


