package com.theindianmaharajatours.app.services;

import com.generated.code.model.Car;
import com.theindianmaharajatours.app.dao.entities.CarEntity;
import com.theindianmaharajatours.app.dao.repository.CarRepository;
import com.theindianmaharajatours.app.mappers.CarMapper;
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

    public CarEntity addCar(CarEntity carEntity) {
        return this.carRepository.save(carEntity);
    }

    public void updateCar(CarEntity carEntity) {
        this.carRepository.save(carEntity);
    }

    public List<Car> getAllCars() {
        return CarMapper.INSTANCE.getCars(this.carRepository.findAll());
    }

    public void removeCar(long id) {
        this.carRepository.delete(getCar(id));
    }

    public CarEntity getCar(long id) {
        return this.carRepository.getOne(id);
    }
}
