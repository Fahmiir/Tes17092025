package com.example.order.repository;

import com.example.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value= """
            SELECT o.total_amount,p.status
            FROM order2 o
            JOIN payments p on p.order_id = o.order_id
            """, nativeQuery = true)
    List<Object[]> findTotslSmoundAndOrderStatus();


}
