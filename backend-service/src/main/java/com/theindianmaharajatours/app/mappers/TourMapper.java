package com.theindianmaharajatours.app.mappers;

import com.generated.code.model.Tour;
import com.theindianmaharajatours.app.dao.entities.TourEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TourMapper {
    TourMapper INSTANCE = Mappers.getMapper(TourMapper.class);
    @Mapping(source = "tourId", target = "id")
    Tour tourEntityToTour(TourEntity tourEntity);
    List<Tour> getTours(List<TourEntity> tourEntities);
}
