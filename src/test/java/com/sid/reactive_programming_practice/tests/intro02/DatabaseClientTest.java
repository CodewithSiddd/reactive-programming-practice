package com.sid.reactive_programming_practice.tests.intro02;

import com.sid.reactive_programming_practice.intro02.dto.OrderDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.test.StepVerifier;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseClientTest extends  AbstractTest{

    private static final Logger log = LoggerFactory.getLogger(DatabaseClientTest.class);

    @Autowired
    private DatabaseClient client;

    @Test
    public void orderDetailsByProduct() {
        var query = """
                SELECT
                    co.order_id,
                    c.name AS customer_name,
                    p.description AS product_name,
                    co.amount,
                    co.order_date
                FROM
                    customer c
                INNER JOIN customer_order co ON c.id = co.customer_id
                INNER JOIN product p ON co.product_id = p.id
                WHERE
                    p.description = :description
                ORDER BY co.amount DESC
                """;
        this.client.sql(query)
                .bind("description", "iphone 20")
                .mapProperties(OrderDetails.class)
                .all()
                .doOnNext(dto -> log.info("{}", dto))
                .as(StepVerifier::create)
                .assertNext(dto -> Assertions.assertEquals(975, dto.amount()))
                .assertNext(dto -> Assertions.assertEquals(950, dto.amount()))
                .expectComplete()
                .verify();
    }

}
