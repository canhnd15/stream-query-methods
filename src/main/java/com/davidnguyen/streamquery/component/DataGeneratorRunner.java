package com.davidnguyen.streamquery.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGeneratorRunner implements CommandLineRunner {
    private final DataGenerator dataGenerator;

    public DataGeneratorRunner(DataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    @Override
    public void run(String... args) throws Exception {
        // Generate 10,000 customers, each with 10 orders (100,000 total orders)
//        dataGenerator.generateLargeData(10000, 10);
    }
}
