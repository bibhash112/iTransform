package com.carwash.cardetails.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.carwash.cardetails.model.Car;

public interface CarRepository extends MongoRepository<Car, Integer> {


}
