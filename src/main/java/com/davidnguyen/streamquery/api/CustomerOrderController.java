package com.davidnguyen.streamquery.api;

import com.davidnguyen.streamquery.service.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerOrderController {
    private final CustomerOrderService customerOrderService;

    @GetMapping("/order")
    public ResponseEntity<Map<String, Double>> getCustomerOderSummary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam Double minOrderAmount
    ) {

        long startTime = System.nanoTime();
        Map<String, Double> orderSummary = customerOrderService.getCustomerOrderSummary(startDate, minOrderAmount);
        long endTime = System.nanoTime();

        System.out.println("Stream execution time: " + (endTime - startTime) / 1_000_000 + " ms");

        return ResponseEntity.ok(orderSummary);
    }
}
