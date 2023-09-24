package jpabook.jpashop.repository.order.simpleQuery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;

    // 생성자의 파라미터에 o(엔티티)를 쓰면 식별자만 넘어가기 때문에 일일히 하나씩 넣오줌
    public List<OrderSimpleQueryDto> findOrderDtos() {
        return em.createQuery("select " +
                "new jpabook.jpashop.repository.order.simpleQuery.OrderSimpleQueryDto(o.id, m.username, o.orderDate, o.orderStatus, d.address) " +
                "from Order o " +
                "join o.member m " +
                "join o.delivery d", OrderSimpleQueryDto.class).getResultList();

    }
}
