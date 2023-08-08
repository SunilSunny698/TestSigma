package com.intro.delivery.model;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;

    @Column(name = "payment", nullable = false)
    private boolean payment;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    public enum OrderStatus{
        PENDING,DELIVERED,RETURN
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
