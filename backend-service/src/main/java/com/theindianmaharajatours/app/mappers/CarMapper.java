package com.theindianmaharajatours.app.mappers;

import com.generated.code.model.Car;
import com.theindianmaharajatours.app.dao.entities.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    List<Car> getCars(List<CarEntity> carEntities);
}
