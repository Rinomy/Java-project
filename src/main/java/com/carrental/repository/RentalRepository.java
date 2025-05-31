package com.carrental.repository;

import com.carrental.entity.RentalCar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends CrudRepository<RentalCar, Long>, PagingAndSortingRepository<RentalCar, Long> {
}
