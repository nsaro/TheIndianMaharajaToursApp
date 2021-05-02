package com.theindianmaharajatours.app.dao.repository;

import com.theindianmaharajatours.app.dao.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
