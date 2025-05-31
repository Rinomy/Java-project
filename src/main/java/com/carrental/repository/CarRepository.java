package com.carrental.repository;

import com.carrental.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>, PagingAndSortingRepository<Car, Long> {
    Page<Car> findAllByIsAvailable(Boolean isAvailable, Pageable pageable);
}
