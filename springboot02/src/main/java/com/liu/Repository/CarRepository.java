package com.liu.Repository;

import com.liu.pojo.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface CarRepository extends JpaRepository<Car, Integer>, JpaSpecificationExecutor<Car> {

}
