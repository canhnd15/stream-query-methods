package com.davidnguyen.streamquery.repository;

import com.davidnguyen.streamquery.entity.Customer;
import jakarta.persistence.QueryHint;
import org.hibernate.jpa.AvailableHints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("""
                SELECT c FROM tbl_customer c JOIN FETCH c.orders o WHERE o.orderDate >= :startDate
            """)
    @QueryHints(
            @QueryHint(name = AvailableHints.HINT_FETCH_SIZE, value = "25")
    )
    Stream<Customer> findCustomerWithOrders(@Param("startDate") LocalDateTime startDate);
}
