package com.davidnguyen.streamquery.service;

import com.davidnguyen.streamquery.entity.Customer;
import com.davidnguyen.streamquery.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CustomerOrderService {
    private final CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public Map<String, Double> getCustomerOrderSummary(LocalDateTime startDate, Double minOrderAmount) {
        try (Stream<Customer> customerStream = customerRepository.findCustomerWithOrders(startDate)) {
            return customerStream
                    // Filter customers with orders above the threshold
                    .flatMap(customer -> customer.getOrders().stream()
                            .filter(order -> order.getAmount() >= minOrderAmount)
                            .map(order -> new AbstractMap.SimpleEntry<>(customer.getName(), order.getAmount())))
                    // Group by customer name and sum order amounts
                    .collect(Collectors.groupingBy(
                            AbstractMap.SimpleEntry::getKey,
                            Collectors.summingDouble(AbstractMap.SimpleEntry::getValue)
                    ));
        }
    }
}
