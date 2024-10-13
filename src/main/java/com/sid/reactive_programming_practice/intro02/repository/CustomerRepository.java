package com.sid.reactive_programming_practice.intro02.repository;

import com.sid.reactive_programming_practice.intro02.entity.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {

    Flux<Customer> findByName(String name);

    Flux<Customer> findByEmailEndingWith(String email);

}

