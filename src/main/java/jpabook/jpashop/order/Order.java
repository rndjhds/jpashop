package jpabook.jpashop.order;

import jpabook.jpashop.delivery.Delivery;
import jpabook.jpashop.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@SequenceGenerator(
        name = "ORDER_SEQ_GENERATOR",
        sequenceName = "ORDER_SEQ",
        allocationSize = 50,
        initialValue = 1
)
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ_GENERATOR")
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // ORDER, CANCEL
}