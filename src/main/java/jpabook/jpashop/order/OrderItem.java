package jpabook.jpashop.order;

import jpabook.jpashop.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "ORDER_ITEM_SEQ_GENERATOR",
        sequenceName = "ORDER_ITEM_SEQ",
        initialValue = 1,
        allocationSize = 50
)
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_ITEM_SEQ_GENERATOR")
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private int orderPrice;

    private int count;
}
