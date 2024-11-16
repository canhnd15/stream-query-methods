package com.davidnguyen.streamquery.component;

import com.davidnguyen.streamquery.entity.Customer;
import com.davidnguyen.streamquery.entity.Order;
import com.davidnguyen.streamquery.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class DataGenerator {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public void generateLargeData(int customerCount, int ordersPerCustomer) {
        List<Customer> customers = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= customerCount; i++) {
            Customer customer = new Customer();
            customer.setName("Customer_" + i);
            customer.setEmail("customer" + i + "@example.com");

            List<Order> orders = new ArrayList<>();
            for (int j = 1; j <= ordersPerCustomer; j++) {
                Order order = new Order();
                order.setOrderDate(LocalDateTime.now().minusDays(random.nextInt(365)));
                order.setAmount(getRandomAmount(20, 500));
                order.setCustomer(customer);
                orders.add(order);
            }
            customer.setOrders(orders);

            customers.add(customer);

            if (i % 500 == 0 || i == customerCount) {
                customerRepository.saveAll(customers);
                customers.clear();
                System.out.println("Saved " + i + " customers...");
            }
        }
        System.out.println("Data generation completed!");
    }

    public static double getRandomAmount(double min, double max) {
        return min + (max - min) * ThreadLocalRandom.current().nextDouble();
    }
}
