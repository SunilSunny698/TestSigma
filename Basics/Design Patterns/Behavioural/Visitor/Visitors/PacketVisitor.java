package Visitors;

import Elements.*;
public interface PacketVisitor {
    public void visit(TCP packet);
    public void visit(UDP packet);
    public void visit(ICMP packet);
}