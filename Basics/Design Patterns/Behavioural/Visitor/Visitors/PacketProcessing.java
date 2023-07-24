package Visitors;

import Elements.ICMP;
import Elements.TCP;
import Elements.UDP;

public class PacketProcessing implements PacketVisitor{

    @Override
    public void visit(TCP packet) {
        System.out.println("Processing TCP packet...");
    }

    @Override
    public void visit(UDP packet) {
        System.out.println("Processing UDP packet...");
    }

    @Override
    public void visit(ICMP packet) {
        System.out.println("Processing ICMP packet...");
    }
    
}
