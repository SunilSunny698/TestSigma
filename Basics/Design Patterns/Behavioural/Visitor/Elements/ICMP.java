package Elements;

import Visitors.PacketVisitor;

public class ICMP implements Packet{
    public void accept(PacketVisitor visitor){
        visitor.visit(this);
    }
}
