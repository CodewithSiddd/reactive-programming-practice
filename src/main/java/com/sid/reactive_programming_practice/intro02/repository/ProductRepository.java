package com.sid.reactive_programming_practice.intro02.repository;

import com.sid.reactive_programming_practice.intro02.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {

    Flux<com.sid.reactive_programming_practice.intro02.entity.Product> findByPriceBetween(int from, int to);

    Flux<com.sid.reactive_programming_practice.intro02.entity.Product> findBy(Pageable pageable);
}
