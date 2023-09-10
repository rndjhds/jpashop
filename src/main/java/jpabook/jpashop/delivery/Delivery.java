package jpabook.jpashop.delivery;

import jpabook.jpashop.member.Address;
import jpabook.jpashop.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "DELIVERY_SEQ_GENERATOR",
        sequenceName = "DELIVERY_SEQ",
        initialValue = 1,
        allocationSize = 50
)
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DELIVERY_SEQ_GENERATOR")
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
}
