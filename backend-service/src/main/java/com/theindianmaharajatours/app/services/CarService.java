package com.theindianmaharajatours.app.services;

import com.theindianmaharajatours.app.dao.entities.Car;
import com.theindianmaharajatours.app.dao.repository.CarRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService {

    private final CarRepository carRepository;
    CarService(CarRepository carRepository)
    {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car) {
        return this.carRepository.save(car);
    }

    public void updateCar(Car car) {
        this.carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }

    public void removeCar(long id) {
        Car car = getCar(id);
        this.carRepository.delete(car);
    }

    public Car getCar(long id) {
        return this.carRepository.getOne(id);
    }
}
