package Elements;

import Visitors.PacketVisitor;

public interface Packet {
    public void accept(PacketVisitor visitor);
}
