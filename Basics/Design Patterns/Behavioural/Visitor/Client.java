import Elements.ICMP;
import Elements.Packet;
import Elements.TCP;
import Elements.UDP;
import Visitors.PacketProcessing;
import Visitors.PacketVisitor;

public class Client {
    public static void main(String[] args) {
        Packet[] packets = {new UDP(),new TCP(),new ICMP()};
        PacketVisitor packetVisitor = new PacketProcessing();
        for (Packet packet : packets) {
            packet.accept(packetVisitor);
        }
    }
}
